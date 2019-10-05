package tran.compbuildbackend.controllers.computerbuild;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tran.compbuildbackend.domain.computerbuild.Purpose;
import tran.compbuildbackend.payload.computerbuild.ComputerBuildDetailResponse;
import tran.compbuildbackend.services.computerbuild.PurposeService;
import tran.compbuildbackend.validator.MapValidationErrorService;

import javax.validation.Valid;

import static tran.compbuildbackend.constants.computerbuild.ComputerBuildConstants.PURPOSE_DELETE_MESSAGE;
import static tran.compbuildbackend.constants.mapping.MappingConstants.*;

@RestController
@RequestMapping(PURPOSE_API)
@CrossOrigin("https://todd-comp-build-frontend.herokuapp.com/")
public class PurposeController {

    private PurposeService purposeService;

    private MapValidationErrorService mapValidationErrorService;

    public PurposeController(PurposeService purposeService, MapValidationErrorService mapValidationErrorService) {
        this.purposeService = purposeService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping(BUILD_IDENTIFIER_PATH_VARIABLE)
    public ResponseEntity<?> createPurpose(@Valid @RequestBody Purpose purpose, BindingResult bindingResult,
                                                    @PathVariable String buildIdentifier) {
        mapValidationErrorService.outputCustomError(bindingResult);

        // no errors so create the purpose.
        Purpose createdPurpose = purposeService.create(buildIdentifier, purpose);

        return new ResponseEntity<>(createdPurpose, HttpStatus.CREATED);
    }

    @PatchMapping(INDIVIDUAL_DETAIL)
    public ResponseEntity<?> updatePurpose(@Valid @RequestBody Purpose newPurpose, BindingResult bindingResult,
                                                    @PathVariable String uniqueIdentifier) {
        mapValidationErrorService.outputCustomError(bindingResult);

        // no errors so update the purpose.
        Purpose updatedPurpose = purposeService.update(newPurpose, uniqueIdentifier);
        return new ResponseEntity<>(updatedPurpose, HttpStatus.OK);
    }

    @DeleteMapping(INDIVIDUAL_DETAIL)
    public ResponseEntity<?> deletePurpose(@PathVariable String uniqueIdentifier) {
        Purpose deletedPurpose = purposeService.delete(uniqueIdentifier);

        // no errors at this point with deletion so return a success message.
        return new ResponseEntity<>(new ComputerBuildDetailResponse(PURPOSE_DELETE_MESSAGE,
                deletedPurpose.getUniqueIdentifier()), HttpStatus.OK);
    }

    @GetMapping(INDIVIDUAL_DETAIL)
    public ResponseEntity<?> getPurposeByIdentifier(@PathVariable String uniqueIdentifier) {
        // get the purpose and return its contents in the response.
        Purpose purpose = purposeService.getFromUniqueIdentifier(uniqueIdentifier);

        return new ResponseEntity<>(purpose, HttpStatus.OK);
    }
}

package tran.compbuildbackend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.constants.tests.TestUtility;
import tran.compbuildbackend.domain.computerbuild.*;
import tran.compbuildbackend.domain.user.ApplicationUser;
import tran.compbuildbackend.payload.email.LoginRequest;
import tran.compbuildbackend.services.computerbuild.*;
import tran.compbuildbackend.services.users.ApplicationUserService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.StreamSupport;

import static tran.compbuildbackend.constants.computerbuild.ComputerBuildConstants.*;
import static tran.compbuildbackend.constants.computerbuild.ProductionComputerBuildConstants.*;
import static tran.compbuildbackend.constants.users.UserConstants.*;
import static tran.compbuildbackend.controllers.utility.WebUtility.logUserIn;
import static tran.compbuildbackend.controllers.utility.WebUtility.logUserOut;

@Component
@Profile(TestUtility.PRODUCTION_PROFILE)
public class ProductionBootstrapData extends AbstractBootStrapData {

    @Autowired
    public ProductionBootstrapData(ApplicationUserService applicationUserService, ComputerBuildService computerBuildService) {
        super(applicationUserService, computerBuildService);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        removeAllUsers();

        if(checkUsers()) {
            createUsers();
        }
        if(checkBuilds()) {
            createSampleBuilds();
        }
    }

    @Override
    protected void createUsers() {
        // create two users that are enabled.
        ApplicationUser user = createUser(USER_NAME_ONE, USER_ONE_EMAIL, USER_PASSWORD, FULL_NAME_ONE);

        // create a user with an account that is not enabled.
        ApplicationUser secondUser = createUser(USER_NAME_TWO, USER_TWO_EMAIL, USER_PASSWORD, FULL_NAME_TWO);

        // save/create users
        applicationUserService.persistUser(user, null);
        applicationUserService.enableUser(user);

        applicationUserService.persistUser(secondUser, null);
        applicationUserService.enableUser(secondUser);
    }

    @Override
    protected void createSampleBuilds() {
        LoginRequest loginRequest = new LoginRequest(USER_NAME_TWO, USER_PASSWORD);
        logUserIn(authenticationService, authenticationManager, jwtTokenProvider, loginRequest);
        createSampleComputerBuilds();
        logUserOut();
    }

    @Override
    protected void createSampleComputerBuilds() {
        createAlternativeRyzenBuild();
        createProposedRyzenBuild();
    }

    private void createAlternativeRyzenBuild() {
        List<Direction> altRyzenBuildDirections = new LinkedList<>();
        addDirections(altRyzenBuildDirections, DIRECTION_ONE_FOR_ALT_RYZEN_BUILD);

        List<OverclockingNote> altRyzenBuildOverclockingNotes = new LinkedList<>();
        addOverclockingNotes(altRyzenBuildOverclockingNotes, OVERCLOCKING_NOTE_ONE_FOR_ALT_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<Purpose> altRyzenBuildPurposeList = new LinkedList<>();
        addPurpose(altRyzenBuildPurposeList, PURPOSE_ONE_FOR_ALT_RYZEN_BUILD, DEFAULT_PRIORITY);
        addPurpose(altRyzenBuildPurposeList, PURPOSE_TWO_FOR_ALT_RYZEN_BUILD, DEFAULT_PRIORITY);
        addPurpose(altRyzenBuildPurposeList, PURPOSE_THREE_FOR_ALT_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<BuildNote> altRyzenBuildBuildNotes = new LinkedList<>();
        addBuildNotes(altRyzenBuildBuildNotes, BUILD_NOTE_ONE_FOR_ALT_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<ComputerPart> altRyzenBuildComputerParts = new LinkedList<>();
        addComputerParts(altRyzenBuildComputerParts, ALT_RYZEN_BUILD_PROCESSOR_NAME, ALT_RYZEN_BUILD_PROCESSOR_PRICE,
                CENTRAL_COMPUTER_LOCATION, ALT_RYZEN_BUILD_PROCESSOR_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(altRyzenBuildComputerParts, ALT_RYZEN_BUILD_MOTHERBOARD_NAME, ALT_RYZEN_BUILD_MOTHERBOARD_PRICE,
                AMAZON_LOCATION, ALT_RYZEN_BUILD_MOTHERBOARD_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(altRyzenBuildComputerParts, RAM_NAME, RAM_PRICE, AMAZON_LOCATION, RAM_NOTE_ONE, PURCHASE_DATE_ONE);
        addComputerParts(altRyzenBuildComputerParts, CASE_NAME, CASE_PRICE, AMAZON_LOCATION, CASE_NOTES, PURCHASE_DATE_TWO);
        addComputerParts(altRyzenBuildComputerParts, ALT_RYZEN_BUILD_VIDEO_CARD_NAME, ALT_RYZEN_BUILD_VIDEO_CARD_PRICE,
                EVGA_LOCATION, ALT_RYZEN_BUILD_VIDEO_CARD_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(altRyzenBuildComputerParts, ALT_RYZEN_BUILD_POWER_SUPPLY_NAME, ALT_RYZEN_BUILD_POWER_SUPPLY_PRICE,
                AMAZON_LOCATION, ALT_RYZEN_BUILD_POWER_SUPPLY_NOTES, PURCHASE_DATE_ONE);
        createSampleComputerBuild(ALTERNATIVE_RYZEN_BUILD_NAME, DESCRIPTION_FOR_ALT_RYZEN_BUILD,
                altRyzenBuildDirections, altRyzenBuildComputerParts, altRyzenBuildOverclockingNotes, altRyzenBuildPurposeList, altRyzenBuildBuildNotes);
    }

    private void createProposedRyzenBuild() {
        List<Direction> proposedRyzenBuildDirections = new LinkedList<>();
        addDirections(proposedRyzenBuildDirections, DIRECTION_ONE_FOR_PROPOSED_RYZEN_BUILD);

        List<OverclockingNote> proposedRyzenBuildOverclockingNotes = new LinkedList<>();
        addOverclockingNotes(proposedRyzenBuildOverclockingNotes, OVERCLOCKING_NOTE_ONE_FOR_PROPOSED_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<Purpose> proposedRyzenBuildPurposeList = new LinkedList<>();
        addPurpose(proposedRyzenBuildPurposeList, PURPOSE_ONE_FOR_PROPOSED_RYZEN_BUILD, DEFAULT_PRIORITY);
        addPurpose(proposedRyzenBuildPurposeList, PURPOSE_TWO_FOR_PROPOSED_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<BuildNote> proposedRyzenBuildBuildNotes = new LinkedList<>();
        addBuildNotes(proposedRyzenBuildBuildNotes, BUILD_NOTE_ONE_FOR_PROPOSED_RYZEN_BUILD, DEFAULT_PRIORITY);

        List<ComputerPart> proposedRyzenBuildComputerParts = new LinkedList<>();
        addComputerParts(proposedRyzenBuildComputerParts, PROPOSED_RYZEN_BUILD_PROCESSOR_NAME, PROPOSED_RYZEN_BUILD_PROCESSOR_PRICE,
                CENTRAL_COMPUTER_LOCATION, PROPOSED_RYZEN_BUILD_PROCESSOR_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(proposedRyzenBuildComputerParts, PROPOSED_RYZEN_BUILD_MOTHERBOARD_NAME, PROPOSED_RYZEN_BUILD_MOTHERBOARD_PRICE,
                AMAZON_LOCATION, PROPOSED_RYZEN_BUILD_MOTHERBOARD_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(proposedRyzenBuildComputerParts, RAM_NAME, RAM_PRICE, AMAZON_LOCATION, RAM_NOTE_ONE, PURCHASE_DATE_ONE);
        addComputerParts(proposedRyzenBuildComputerParts, CASE_NAME, CASE_PRICE, AMAZON_LOCATION, CASE_NOTES, PURCHASE_DATE_TWO);
        addComputerParts(proposedRyzenBuildComputerParts, PROPOSED_RYZEN_BUILD_VIDEO_CARD_NAME, PROPOSED_RYZEN_BUILD_VIDEO_CARD_PRICE,
                EVGA_LOCATION, PROPOSED_RYZEN_BUILD_VIDEO_CARD_NOTES, PURCHASE_DATE_ONE);
        addComputerParts(proposedRyzenBuildComputerParts, PROPOSED_RYZEN_BUILD_POWER_SUPPLY_NAME, PROPOSED_RYZEN_BUILD_POWER_SUPPLY_PRICE,
                AMAZON_LOCATION, PROPOSED_RYZEN_BUILD_POWER_SUPPLY_NOTES, PURCHASE_DATE_ONE);
        createSampleComputerBuild(PROPOSED_RYZEN_BUILD_NAME, DESCRIPTION_FOR_PROPOSED_RYZEN_BUILD,
                proposedRyzenBuildDirections, proposedRyzenBuildComputerParts, proposedRyzenBuildOverclockingNotes, proposedRyzenBuildPurposeList, proposedRyzenBuildBuildNotes);
    }

    private boolean checkUsers() {
        Iterable<ApplicationUser> users = applicationUserService.getAllUsers();
        return StreamSupport.stream(users.spliterator(), false).count() < 1;
    }

    private boolean checkBuilds() {
        Iterable<ComputerBuild> builds = computerBuildService.getAllComputerBuilds();
        return StreamSupport.stream(builds.spliterator(), false).count() < 1;
    }

    private void removeAllUsers() {
        Iterable<ApplicationUser> users = applicationUserService.getAllUsers();
        users.forEach(user -> applicationUserService.removeUser(user));
    }
}

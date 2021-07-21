package tran.compbuildbackend.bootstrap;

import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.constants.tests.TestUtility;
import tran.compbuildbackend.security.JwtTokenProvider;
import tran.compbuildbackend.services.computerbuild.*;
import tran.compbuildbackend.services.security.ApplicationUserAuthenticationService;
import tran.compbuildbackend.services.users.ApplicationUserService;

@Component
@Profile(TestUtility.TEST_PROFILE)
public class DevBootstrapData extends AbstractBootStrapData {

    public DevBootstrapData(ApplicationUserService applicationUserService, ComputerBuildService computerBuildService,
                            AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
                            ApplicationUserAuthenticationService authenticationService, ComputerPartService computerPartService,
                            DirectionService directionService, BuildNoteService buildNoteService, PurposeService purposeService,
                            OverclockingNoteService overclockingNoteService) {
        super(applicationUserService, computerBuildService, authenticationManager, jwtTokenProvider, authenticationService,
                computerPartService, directionService, buildNoteService, purposeService, overclockingNoteService);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        super.onApplicationEvent(contextRefreshedEvent);
    }

}

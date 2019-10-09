package tran.compbuildbackend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.constants.tests.TestUtility;
import tran.compbuildbackend.services.computerbuild.ComputerBuildService;
import tran.compbuildbackend.services.users.ApplicationUserService;

@Component
@Profile(TestUtility.TEST_PROFILE)
public class DevBootstrapData extends AbstractBootStrapData {
    @Autowired
    public DevBootstrapData(ApplicationUserService applicationUserService, ComputerBuildService computerBuildService) {
        super(applicationUserService, computerBuildService);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        super.onApplicationEvent(contextRefreshedEvent);
    }

}

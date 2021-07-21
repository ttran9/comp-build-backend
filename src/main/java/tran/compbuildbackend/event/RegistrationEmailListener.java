package tran.compbuildbackend.event;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.event.utility.EventUtil;
import tran.compbuildbackend.services.verificationtoken.VerificationTokenService;

import static tran.compbuildbackend.constants.email.EmailConstants.REGISTRATION_SUCCESS_CONFIRMATION;
import static tran.compbuildbackend.constants.mapping.MappingConstants.CONFIRM_REGISTRATION_ENDPOINT;

@Component
public class RegistrationEmailListener implements ApplicationListener<OnRegistrationSuccessEvent> {

    private final VerificationTokenService verificationTokenService;

    public RegistrationEmailListener(@Qualifier("emailVerificationTokenServiceImpl") VerificationTokenService verificationTokenService) {
        this.verificationTokenService = verificationTokenService;
    }

    @Override
    public void onApplicationEvent(OnRegistrationSuccessEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationSuccessEvent event) {
        try {
            String subject = "Confirm Registration";
            EventUtil.sendEmail(event, verificationTokenService, REGISTRATION_SUCCESS_CONFIRMATION,
                    subject, CONFIRM_REGISTRATION_ENDPOINT);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new UsernameNotFoundException("account cannot be created at this time");
        }
    }

}

package tran.compbuildbackend.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.event.utility.EventUtil;
import tran.compbuildbackend.services.verificationtoken.ChangePasswordTokenServiceImpl;
import tran.compbuildbackend.services.verificationtoken.VerificationTokenService;

import static tran.compbuildbackend.constants.email.EmailConstants.PASSWORD_CHANGE_REQUEST;
import static tran.compbuildbackend.constants.exception.ExceptionConstants.PASSWORD_CANNOT_BE_CHANGED;
import static tran.compbuildbackend.constants.mapping.MappingConstants.CHANGE_PASSWORD_ENDPOINT;
import static tran.compbuildbackend.exceptions.ExceptionUtility.throwMessageException;

@Component
public class ChangePasswordListener implements ApplicationListener<OnPasswordResetRequestEvent> {
    private ChangePasswordTokenServiceImpl changePasswordTokenService;

    public ChangePasswordListener(ChangePasswordTokenServiceImpl changePasswordTokenService) {
        this.changePasswordTokenService = changePasswordTokenService;
    }

    @Override
    public void onApplicationEvent(OnPasswordResetRequestEvent event) {
        this.changePasswordRequest(event);
    }

    private void changePasswordRequest(OnPasswordResetRequestEvent event) {
        try {
            String subject = "Change Password";
            EventUtil.sendEmail(event, changePasswordTokenService, PASSWORD_CHANGE_REQUEST,
                    subject, CHANGE_PASSWORD_ENDPOINT);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            throwPasswordException(PASSWORD_CANNOT_BE_CHANGED);
            throwMessageException(PASSWORD_CANNOT_BE_CHANGED);
        }
    }
}

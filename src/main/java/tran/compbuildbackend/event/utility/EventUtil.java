package tran.compbuildbackend.event.utility;

import com.sendgrid.*;
import tran.compbuildbackend.domain.user.ApplicationUser;
import tran.compbuildbackend.event.AbstractApplicationEvent;
import tran.compbuildbackend.services.verificationtoken.VerificationTokenService;

import java.io.IOException;

import static tran.compbuildbackend.constants.security.SecurityConstants.EMAIL_SENDER_PASSWORD;
import static tran.compbuildbackend.constants.security.SecurityConstants.EMAIL_SENDER_USERNAME;

public class EventUtil {

    public static void sendEmail(AbstractApplicationEvent event, VerificationTokenService tokenService,
                                 String messsageContent, String subject, String urlPath) {
        ApplicationUser user = event.getUser();
        String token = tokenService.createVerificationToken(user);

        String recipient = user.getEmail();

        String url = event.getAppUrl() + urlPath + token;

        Email from = new Email(EMAIL_SENDER_USERNAME);
        Email to = new Email(recipient);

        Content content = new Content("text/plain", messsageContent + "\n" + url);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(EMAIL_SENDER_PASSWORD);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException ex) {
            System.out.println("Trouble sending e-mail more detail below!");
            System.out.println(ex.getMessage());
        }
    }

}

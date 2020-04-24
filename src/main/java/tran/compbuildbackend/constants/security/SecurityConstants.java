package tran.compbuildbackend.constants.security;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import tran.compbuildbackend.config.config.ConfigReader;

import static tran.compbuildbackend.constants.config.ConfigurationConstants.CONFIGURATION_FILE_LOCATION;

@Component
public class SecurityConstants {

    public SecurityConstants() {
        initializeData();
    }

    private void initializeData() {
        ConfigReader reader = new ConfigReader();
        JSONObject jsonObject = reader.getBackendConfigurationContent(CONFIGURATION_FILE_LOCATION);
        String secretKey = reader.getContentFromKey(jsonObject, SECRET_KEY);
        SECRET = secretKey != null ? secretKey : "password";
        String emailUserName = reader.getContentFromKey(jsonObject, EMAIL_LOGIN_KEY);
        EMAIL_SENDER_LOGIN = emailUserName != null ? emailUserName : "username";
        String emailPassword = reader.getContentFromKey(jsonObject, EMAIL_PASSWORD_KEY);
        EMAIL_SENDER_PASSWORD = emailPassword != null ? emailPassword : "password";
        String fromEmail = reader.getContentFromKey(jsonObject, EMAIL_SENDER_USERNAME_KEY);
        // note that the below will cause the email sender to fail if the key doesn't return anything.
        EMAIL_SENDER_USERNAME = fromEmail != null ? fromEmail : "test@example.com";
        String emailHost = reader.getContentFromKey(jsonObject, EMAIL_HOST_KEY);
        EMAIL_HOST = emailHost != null ? emailHost : "";
    }

    // endpoints
    public static final String SIGN_UP_URLS = "/api/users/**";
    public static final String H2_URL = "/h2-console/**";

    // JWT authentication related content
    public static final String SECRET_KEY = "JWT_PRIV_KEY";
//    public static String SECRET = System.getenv("JWT_PRIV_KEY");
    public static String SECRET = null;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 2700000; // in milliseconds so 2700 seconds / 45 mins.

    // email credentials
    public static String EMAIL_SENDER_LOGIN = null;
    public static String EMAIL_HOST = null;
    public static final String EMAIL_HOST_KEY = "EMAIL_HOST_KEY";
    //    public static String EMAIL_LOGIN = System.getenv("TEST_EMAIL");
    public static final String EMAIL_LOGIN_KEY = "TEST_EMAIL";
    public static String EMAIL_SENDER_PASSWORD = null;
//    public static String EMAIL_PASSWORD = System.getenv("TEST_PASSWORD");
//    public static String EMAIL_PASSWORD = System.getenv("TEST_EMAIL_PASSWORD");
    public static final String EMAIL_PASSWORD_KEY = "TEST_JAVA_EMAIL_PASSWORD";
    public static String EMAIL_SENDER_USERNAME = null;
    public static String EMAIL_SENDER_USERNAME_KEY = "SENDER_EMAIL";

    // constants for token verification.
    public static final int CHANGE_PASSWORD_TOKEN_TYPE = 1;
    public static final int EMAIL_VERIFICATION_TOKEN_TYPE = 2;
}

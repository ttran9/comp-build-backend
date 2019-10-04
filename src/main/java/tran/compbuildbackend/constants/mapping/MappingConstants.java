package tran.compbuildbackend.constants.mapping;

public class MappingConstants {

    public static final String URLS_REGEX = "^\\/[a-zA-Z]+\\/{0,1}$";
    public static final String PB_UPT_REGEX = "\\/[a-zA-Z0-9]+\\/[a-zA-Z0-9]{1,25}";
    public static final String COMPUTER_BUILD_DETAIL_REGEX = "\\/[a-zA-Z0-9]+\\/[a-zA-Z0-9]{1,25}\\/[a-zA-Z0-9]{1,25}";

    public static final String URL_SEPARATOR = "/";

    // front end mapping
    public static final String FRONT_END_MAPPING = "https://todd-comp-build-frontend.herokuapp.com/";

    // ApplicationUserController
    public static final String CONFIRM_REGISTRATION_URL = "/confirmRegistration/";
    public static final String CHANGE_PASSWORD_URL = "/changePassword/";
    public static final String USERS_API = "/api/users";
    public static final String REGISTER_URL = "/register";
    public static final String LOGIN_URL = "/login";
    public static final String TOKEN_PARAM = "{token}";

    // ComputerBuildController
    public static final String COMPUTER_BUILD_API = "/api/computerbuild/";
    public static final String BUILD_IDENTIFIER_PATH_VARIABLE = "{buildIdentifier}";
    public static final String USER_NAME_REQUEST = "username/";
    public static final String USER_NAME_PATH_VARIABLE = "{username}";

    // ComputerPartController
    public static final String COMPUTER_PART_API = "/api/computerpart/";
    public static final String UNIQUE_IDENTIFIER_PATH_VARIABLE = "{uniqueIdentifier}";

    // DirectionController
    public static final String DIRECTION_API = "/api/direction/";

    // OverclockingNoteController
    public static final String OVERCLOCKING_NOTE_API = "/api/overclockingnote/";

    // PurposeController
    public static final String PURPOSE_API = "/api/purpose/";

    // BuildNoteController
    public static final String BUILD_NOTE_API = "/api/buildnote/";

    // other common across multiple controllers...
    public static final String INDIVIDUAL_DETAIL = BUILD_IDENTIFIER_PATH_VARIABLE + URL_SEPARATOR + UNIQUE_IDENTIFIER_PATH_VARIABLE; // build note, computer part, direction, etc.

    // constants below to hold paths for different types of HTTP requests: GET, POST, DELETE, PATCH, etc.
    public static final String[] POST_PATHS = new String[]{BUILD_NOTE_API + BUILD_IDENTIFIER_PATH_VARIABLE, COMPUTER_BUILD_API,
            COMPUTER_PART_API + BUILD_IDENTIFIER_PATH_VARIABLE, DIRECTION_API + BUILD_IDENTIFIER_PATH_VARIABLE, OVERCLOCKING_NOTE_API
            + BUILD_IDENTIFIER_PATH_VARIABLE, PURPOSE_API + BUILD_IDENTIFIER_PATH_VARIABLE};
    public static final String[] PATCH_PATHS = new String[]{BUILD_NOTE_API + INDIVIDUAL_DETAIL, COMPUTER_PART_API +
            INDIVIDUAL_DETAIL, DIRECTION_API + INDIVIDUAL_DETAIL, OVERCLOCKING_NOTE_API + INDIVIDUAL_DETAIL, PURPOSE_API
            + INDIVIDUAL_DETAIL};
    public static final String[] DELETE_PATHS = new String[]{BUILD_NOTE_API + INDIVIDUAL_DETAIL, COMPUTER_BUILD_API +
            BUILD_IDENTIFIER_PATH_VARIABLE, COMPUTER_PART_API + INDIVIDUAL_DETAIL, DIRECTION_API + INDIVIDUAL_DETAIL,
            OVERCLOCKING_NOTE_API + INDIVIDUAL_DETAIL, PURPOSE_API + INDIVIDUAL_DETAIL};
    public static final String[] GET_PATHS = new String[]{BUILD_NOTE_API + INDIVIDUAL_DETAIL, COMPUTER_BUILD_API +
            BUILD_IDENTIFIER_PATH_VARIABLE, COMPUTER_BUILD_API, COMPUTER_BUILD_API + USER_NAME_REQUEST +
            USER_NAME_PATH_VARIABLE, COMPUTER_PART_API + INDIVIDUAL_DETAIL, DIRECTION_API + INDIVIDUAL_DETAIL,
            OVERCLOCKING_NOTE_API + INDIVIDUAL_DETAIL, PURPOSE_API + INDIVIDUAL_DETAIL};
}

package Model.Auth;

public class Authentication {
    private static String loggedInUsername;
    private static String loggedInUserId;
    private static String loggedInUserRole;

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    public static String getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void setLoggedInUserId(String userId) {
        loggedInUserId = userId;
    }

    public static String getLoggedInUserRole() {
        return loggedInUserRole;
    }

    public static void setLoggedInUserRole(String userRole) {
        loggedInUserRole = userRole;
    }
}

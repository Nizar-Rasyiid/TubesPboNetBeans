package Model.Auth;

public class Authentication {
    private static String loggedInUsername;   
    private static String loggedInUserId;

    
    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static String getLoggedInUserId() {
        return loggedInUserId;
    }

 public static void setLoggedInUserId(String userId) {
    loggedInUserId = userId;
}

    
}

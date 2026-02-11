package assignment2.functions;

public class task7 {
    public static void main(String[] args) {
        signIn("user");
        signIn("Amigo");
    }

    public static void signIn(String username) {
        if ("user".equals(username)) {
            return;
        }
        System.out.println("Welcome " + username);
        System.out.println("Missed you very much, " + username);
    }
}


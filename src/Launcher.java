import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome Back !");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String res = scanner.nextLine();
            if (res.equals("quit")) {
                return;
            }

            System.out.println("Unknown command");
        }
    }
}


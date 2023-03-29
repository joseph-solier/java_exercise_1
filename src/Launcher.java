import java.util.Scanner;

public class Launcher {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Welcome Back !");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String res = scanner.nextLine();
            if (res.equals("quit")) {
                return;
            } else {
                if (res.equals("fibo")) {
                    int n = scanner.nextInt();
                    System.out.println(fibonacci(n));
                    scanner.nextLine();
                } else {
                    System.out.println("Unknown command");
                }
            }
        }
    }
}


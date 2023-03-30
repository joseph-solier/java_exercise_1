import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Welcome Back !");

        List<Command> commands = new ArrayList<>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command:");
            String input = scanner.nextLine();
            boolean found = false;

            for (Command command : commands) {
                if (input.equals(command.name())) {
                    found = true;
                    if (command.run(scanner)) {
                        return;
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Unknown command");
            }
        }
    }
}

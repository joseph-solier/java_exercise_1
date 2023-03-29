import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {

    public static void print3words(String path)
    {
        String inputString = path;
        Stream<String> wordsStream = Arrays.stream(inputString.split(" "))
                .map(String::toLowerCase);
        //wordsStream.forEach(System.out::println);
        List<String> list = Arrays.asList("Java", "Python", "Java", "JavaScript", "C++", "Python");

        Map<String, Long> counts = wordsStream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> sortedMap = new LinkedHashMap<>();
        counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        int count = 0;
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            if (count == 2) {
                System.out.println(entry.getKey());
                break;
            }
            System.out.print(entry.getKey() + " ");
            count++;

        }



    }
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

                } else {
                    if (res.equals("freq")) {
                        res = scanner.next();
                        Path chemin = Paths.get(res);
                        try{
                            String contenu= Files.readString(chemin);

                            //System.out.println(contenu);
                            print3words(contenu);

                            scanner.nextLine();
                        }catch(IOException e) {
                            System.out.println("Unreadable file :" + chemin);
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Unknown command");
                    }
                }
            }
        }
    }
}

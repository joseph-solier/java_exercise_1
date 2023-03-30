import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a file path:");
        String res = scanner.nextLine();
        Path path = Paths.get(res);

        try {
            String content = Files.readString(path);
            print3words(content);
        } catch (IOException e) {
            System.out.println("Unreadable file: " + path);
        }

        return false;
    }

    private void print3words(String inputString) {
        Stream<String> wordsStream = Arrays.stream(inputString.split(" "))
                .map(String::toLowerCase);

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
}

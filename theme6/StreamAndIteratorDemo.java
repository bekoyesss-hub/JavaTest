import java.util.ArrayList;
import java.util.List;

public class StreamAndIteratorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Анна");
        names.add("Иван");
        names.add("Петр");
        names.add("Александр");

        names.removeIf(name -> name.startsWith("А"));

        List<Integer> lengths = names.stream()
                .filter(name -> name.length() > 3)
                .map(name -> name.length())
                .toList();

        System.out.println("Длины оставшихся имен: " + lengths);
    }
}
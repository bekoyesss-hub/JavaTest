import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.remove(1);
        
        Integer val = 40;
        list.remove(val);

        System.out.println("Результат: " + list);
    }
}
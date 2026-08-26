public class ReferenceVsValue {
    public static void main(String[] args) {
        int num = 5;
        Box box = new Box(5);

        change(num, box);

        System.out.println("Примитив (num) после метода: " + num);
        System.out.println("Объект (box.val) после метода: " + box.val);
    }

    static void change(int num, Box box) {
        num = 100;
        box.val = 100;
        box = new Box(777);
    }
}

class Box {
    int val;
    Box(int v) {
        this.val = v;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Начальное кол-во читателей: " + Reader.getTotalReadersCount());

        Reader reader1 = new Reader("Алиев Арман", "LIB-001");
        Reader reader2 = new Reader("Сергеева Ольга", "LIB-002", 2023, 3);

        System.out.println(reader1);
        System.out.println(reader2);
        System.out.println("Всего читателей зарегистрировано: " + Reader.getTotalReadersCount());

        System.out.println("\n--- Проверка бизнес-логики ---");
        reader1.takeBook();
        reader1.takeBook();
        reader1.returnBook();

        System.out.println("\n--- Проверка инкапсуляции и валидации ---");
        try {
            Reader invalidReader = new Reader("Иванов Иван", "LIB-999", 1850);
        } catch (IllegalArgumentException e) {
            System.out.println("Перехвачена ошибка: " + e.getMessage());
        }
    }
}
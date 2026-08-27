class EmptyJournalException extends Exception {
    EmptyJournalException(String message) {
        super(message);
    }
}

class Journal<T extends Number> {
    private final Object[] values = new Object[100];
    private int size;

    void add(T value) {
        if (size < values.length) {
            values[size] = value;
            size++;
        }
    }

    int size() {
        return size;
    }

    double average() throws EmptyJournalException {
        if (size == 0) {
            throw new EmptyJournalException("Журнал пуст: невозможно вычислить среднее значение");
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += ((Number) values[i]).doubleValue();
        }
        return sum / size;
    }

    double max() throws EmptyJournalException {
        if (size == 0) {
            throw new EmptyJournalException("Журнал пуст: невозможно найти максимальное значение");
        }
        double maxVal = ((Number) values[0]).doubleValue();
        for (int i = 1; i < size; i++) {
            double current = ((Number) values[i]).doubleValue();
            if (current > maxVal) {
                maxVal = current;
            }
        }
        return maxVal;
    }
}

public class Practice {
    public static void main(String[] args) {
        String[] fromFile = {"120", "135", "сто", "148", "", "151"};
        Journal<Integer> journal = new Journal<>();

        System.out.println("--- 1. Разбор данных и заполнение журнала ---");
        for (String raw : fromFile) {
            try {
                int value = Integer.parseInt(raw.trim());
                journal.add(value);
                System.out.println("Принято значение: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Отклонено некорректное значение: '" + raw + "' (" + e.getMessage() + ")");
            }
        }

        System.out.println("\n--- 2. Вывод статистики журнала ---");
        System.out.println("Принято показаний: " + journal.size());
        try {
            System.out.printf("Среднее значение: %.2f%n", journal.average());
            System.out.printf("Максимальное значение: %.2f%n", journal.max());
        } catch (EmptyJournalException e) {
            System.out.println("Ошибка журнала: " + e.getMessage());
        }

        System.out.println("\n--- 3. Проверка работы с пустым журналом ---");
        Journal<Double> emptyJournal = new Journal<>();
        try {
            System.out.println("Попытка расчета среднего для пустого журнала:");
            emptyJournal.average();
        } catch (EmptyJournalException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }
}
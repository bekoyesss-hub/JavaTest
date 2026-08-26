import java.time.Year;

public class Reader {
    public static final int MAX_BOOKS = 5;
    private static int totalReadersCount = 0;

    private final String fullName;
    private final String ticketNumber;
    private final int registrationYear;
    private int booksOnHand;

    public Reader(String fullName, String ticketNumber, int registrationYear, int booksOnHand) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым.");
        }
        if (ticketNumber == null || ticketNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер билета не может быть пустым.");
        }
        int currentYear = Year.now().getValue();
        if (registrationYear < 1900 || registrationYear > currentYear) {
            throw new IllegalArgumentException("Некорректный год регистрации.");
        }
        if (booksOnHand < 0 || booksOnHand > MAX_BOOKS) {
            throw new IllegalArgumentException("Количество книг должно быть от 0 до " + MAX_BOOKS);
        }

        this.fullName = fullName.trim();
        this.ticketNumber = ticketNumber.trim();
        this.registrationYear = registrationYear;
        this.booksOnHand = booksOnHand;

        totalReadersCount++;
    }

    public Reader(String fullName, String ticketNumber, int registrationYear) {
        this(fullName, ticketNumber, registrationYear, 0);
    }

    public Reader(String fullName, String ticketNumber) {
        this(fullName, ticketNumber, Year.now().getValue(), 0);
    }

    public void takeBook() {
        if (booksOnHand >= MAX_BOOKS) {
            System.out.println("Ошибка: " + fullName + " достиг лимита на выдачу книг (" + MAX_BOOKS + ").");
            return;
        }
        booksOnHand++;
        System.out.println(fullName + " взял 1 книгу. Всего на руках: " + booksOnHand);
    }

    public void returnBook() {
        if (booksOnHand <= 0) {
            System.out.println("Ошибка: у " + fullName + " нет книг для возврата.");
            return;
        }
        booksOnHand--;
        System.out.println(fullName + " вернул 1 книгу. Осталось на руках: " + booksOnHand);
    }

    public String getFullName() { return fullName; }
    public String getTicketNumber() { return ticketNumber; }
    public int getRegistrationYear() { return registrationYear; }
    public int getBooksOnHand() { return booksOnHand; }

    public static int getTotalReadersCount() {
        return totalReadersCount;
    }

    @Override
    public String toString() {
        return "Читатель {" +
                "ФИО='" + fullName + '\'' +
                ", № билета='" + ticketNumber + '\'' +
                ", Год=" + registrationYear +
                ", Книг на руках=" + booksOnHand +
                '}';
    }
}
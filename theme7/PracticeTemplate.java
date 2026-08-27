import java.util.ArrayList;
import java.util.List;

public class PracticeTemplate {
    public static void main(String[] args) {
        List<Debt> debts = new ArrayList<>();
        debts.add(new Debt("Сеитова А.", "студент", 5));
        debts.add(new Debt("Абенов Д.", "преподаватель", 12));
        debts.add(new Debt("Ержанова М.", "гость", 3));
        debts.add(new Debt("Сериков Н.", "аспирант", 7));

        long total = 0;

        for (Debt debt : debts) {
            FineCalculator calc;
            
            if (debt.getKind().equals("студент")) {
                calc = new StudentFine();
            } else if (debt.getKind().equals("преподаватель")) {
                calc = new TeacherFine();
            } else if (debt.getKind().equals("гость")) {
                calc = new GuestFine();
            } else {
                calc = new DefaultFine();
            }

            long fine = calc.calculate(debt.getOverdueDays());
            System.out.printf("%-13s %-14s %2d дн. -> %5d тг%n",
                    debt.getReader(), debt.getKind(), debt.getOverdueDays(), fine);
            
            total += fine;
        }

        System.out.println("итого пени: " + total + " тг");
    }
}

interface FineCalculator {
    long calculate(int days);
}

class StudentFine implements FineCalculator {
    @Override
    public long calculate(int days) {
        return 50L * days;
    }
}

class TeacherFine implements FineCalculator {
    @Override
    public long calculate(int days) {
        return 30L * days;
    }
}

class GuestFine implements FineCalculator {
    @Override
    public long calculate(int days) {
        return 100L * days;
    }
}

class DefaultFine implements FineCalculator {
    @Override
    public long calculate(int days) {
        return 0;
    }
}

class Debt {
    private String reader;
    private String kind;
    private int overdueDays;

    public Debt(String reader, String kind, int overdueDays) {
        this.reader = reader;
        this.kind = kind;
        this.overdueDays = overdueDays;
    }

    public String getReader() {
        return reader;
    }

    public String getKind() {
        return kind;
    }

    public int getOverdueDays() {
        return overdueDays;
    }
}
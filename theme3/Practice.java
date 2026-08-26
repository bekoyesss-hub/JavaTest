public class Practice {
    public static void main(String[] args) {
        Transport[] list = new Transport[4];
        list[0] = new Car("Toyota", 2020, 5);
        list[1] = new Truck("Volvo", 2018, 10);
        list[2] = new Car("BMW", 2022, 4);
        list[3] = new Truck("MAN", 2019, 15);

        int totalCost = 0;

        for (Transport t : list) {
            System.out.println(t.describe());
            totalCost += t.cost(3);

            if (t instanceof Truck tr) {
                System.out.println("  Грузоподъемность: " + tr.getCapacity() + " тонн");
            }
        }

        System.out.println("\nОбщая стоимость аренды на 3 суток: " + totalCost + " тг");
    }
}

class Transport {
    private String model;
    private int year;

    public Transport(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String describe() {
        return "Транспорт: " + model + " (" + year + " год)";
    }

    public int cost(int days) {
        return days * 5000;
    }

    @Override
    public String toString() {
        return describe();
    }
}

class Car extends Transport {
    private int seats;

    public Car(String model, int year, int seats) {
        super(model, year);
        this.seats = seats;
    }

    @Override
    public String describe() {
        return super.describe() + ", мест: " + seats;
    }
}

class Truck extends Transport {
    private int capacity;

    public Truck(String model, int year, int capacity) {
        super(model, year);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String describe() {
        return super.describe() + ", грузоподъемность: " + capacity + " т";
    }

    @Override
    public int cost(int days) {
        return days * 12000;
    }
}
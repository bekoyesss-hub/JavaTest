// ClassVsObject.java — класс это тип, объект это экземпляр в памяти
// Занятие 1. Один класс — сколько угодно объектов с независимым состоянием.

public class ClassVsObject {

    public static void main(String[] args) {
        Lamp kitchen = new Lamp("кухня");     // new создаёт объект в куче
        Lamp hall    = new Lamp("коридор");   // второй объект того же класса

        kitchen.turnOn();
        System.out.println(kitchen.state());
        System.out.println(hall.state());     // состояние второго не изменилось

        Lamp same = kitchen;                  // ещё одна ССЫЛКА на тот же объект
        same.turnOff();
        System.out.println("после same.turnOff():");
        System.out.println(kitchen.state());  // изменение видно и через kitchen

        System.out.println("объектов Lamp создано: " + Lamp.created());
    }
}

class Lamp {

    private static int count = 0;   // одно на весь класс
    private final String room;      // своё у каждого объекта
    private boolean on = false;

    Lamp(String room) {
        this.room = room;
        count++;
    }

    void turnOn() {
        on = true;
    }

    void turnOff() {
        on = false;
    }

    String state() {
        return "лампа «" + room + "»: " + (on ? "включена" : "выключена");
    }

    static int created() {          // статический метод вызывают у класса
        return count;
    }
}

// Переменные kitchen, hall, same — это ссылки. Объектов создано два,
// а ссылок на них три.

import java.util.Scanner;

// Контракт для устройств
interface PrintableDevice {
    String DEFAULT_STATUS = "ГОТОВ";

    void printInfo();

    default void printWithStatus(String text) {
        System.out.println("[" + DEFAULT_STATUS + "] " + text);
    }

    static boolean checkName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}

// Абстрактный класс с базовой логикой
abstract class BaseComputer implements PrintableDevice {
    private String modelName;
    private int ramSize;

    public BaseComputer(String modelName, int ramSize) {
        this.modelName = modelName;
        this.ramSize = ramSize;
    }

    public String getModelName() {
        return modelName;
    }

    public int getRamSize() {
        return ramSize;
    }

    // Шаблонный метод выполнения задачи
    public final void runTask(String taskName) {
        if (!PrintableDevice.checkName(taskName)) {
            System.out.println("Ошибка: имя задачи не задано!");
            return;
        }
        System.out.println("Запуск ПК: " + modelName);
        execute(taskName);
        System.out.println("Задача завершена.\n");
    }

    // Абстрактный метод для реализации в подклассах
    protected abstract void execute(String taskName);
}

// Подкласс 1: Игровой ПК
class GamingPc extends BaseComputer {
    private String gpuModel;

    public GamingPc(String modelName, int ramSize, String gpuModel) {
        super(modelName, ramSize);
        this.gpuModel = gpuModel;
    }

    @Override
    protected void execute(String taskName) {
        printWithStatus("Запуск тяжелой задачи '" + taskName + "' на видеокарте " + gpuModel);
    }

    @Override
    public void printInfo() {
        System.out.println("Игровой ПК: " + getModelName() + " | ОЗУ: " + getRamSize() + "ГБ | Видеокарта: " + gpuModel);
    }
}

// Подкласс 2: Офисный ПК
class OfficePc extends BaseComputer {
    public OfficePc(String modelName, int ramSize) {
        super(modelName, ramSize);
    }

    @Override
    protected void execute(String taskName) {
        printWithStatus("Выполнение офисной задачи '" + taskName + "' в фоновом режиме.");
    }

    @Override
    public void printInfo() {
        System.out.println("Офисный ПК: " + getModelName() + " | ОЗУ: " + getRamSize() + "ГБ");
    }
}

// Главный класс совпадает с именем файла Practice.java
public class Practice {
    public static void main(String[] args) {
        GamingPc gameRig = new GamingPc("ROG Strix", 32, "RTX 4080");
        OfficePc workRig = new OfficePc("Dell OptiPlex", 16);

        gameRig.printInfo();
        gameRig.runTask("Рендеринг сцены");

        workRig.printInfo();
        workRig.runTask("Расчет таблицы Excel");
    }
}
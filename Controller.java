package ru.geekbrains.geektodolist.toyshop;

/**
 * Класс Контроллер для взаимодействия в рамках реализации модели MVC
 */
public class Controller {
    private GamingMachine toyGamingMachine;
    private UserInterface userInterface;

    public Controller() {
        this.toyGamingMachine = new GamingMachine();
        this.userInterface = new UserInterface();
    }

    /**
     * Запускает старт розыгрыша игрушек
     */
    public void start() {
        while (true) {
            System.out.println(UserInterface.menu);
            int select = userInterface.select();
            switch (select) {
                case 1 -> toysLoad();
                case 2 -> toyGamingMachine.getAllToys();
                case 3 -> toyDraw();
                case 4 -> getHelp();
                case 5 -> {
                    return;
                }
            }
        }
    }

    /**
     * Загружает требуемое количество игрушек в автомат для розыгрыша
     */
    void toysLoad() {
        int numberToys = userInterface.askNumber("количество загружаемых в автомат игрушек");
        for (int i = 1; i <= numberToys; i++) {
            String toyName = userInterface.askToyName();
            int frequency = userInterface.askNumber("частоту (вес) выпадения игрушки (от 1 до 10)");
            toyGamingMachine.put(toyName, frequency);
        }
    }

    /**
     * Непосредственно проводит розыгрыш игрушек указанное количество раз и записывает результаты розыгрыша в файл
     */
    public void toyDraw() {
        int numberDraws = userInterface.askNumber("количество проводимых розыгрышей игрушек");
        System.out.println("---------------------------------------------------------");
        for (int i = 1; i <= numberDraws; i++) {
            Toy toy = toyGamingMachine.getToy();
            if (toy == null) {
                System.out.println("Проведение розыгрыша невозможно, так как нет доступных игрушек!\n" +
                        "Необходимо провести загрузку игрушек в автомат.");
            } else {
                String result = "Выпала игрушка: " + toy + "\n";
                System.out.println(result);
                toyGamingMachine.write(result);
            }
        }
    }

    void getHelp() {
        System.out.println("""
                ---------------------------------------------------------
                                         Справка
                ---------------------------------------------------------                  
                    Приложение "Розыгрыш игрушек" позволяет сформировать
                в соответствии с заданным количеством набор игрушек для 
                розыгрыша, указав их названия и необходимые частоты 
                выпадения. После чего выполняется случайным образом 
                розыгрыш указанного количества игрушек из загруженного 
                набора. Результаты розыгрыша выводятся в консоль и
                допонительно сохраняются в файл "result.txt".
                     Также приложение позволяет вывести в консоль 
                подробный список всех участвующих в розыгрыше игрушек.
                """);
    }
}

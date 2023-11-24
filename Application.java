package ru.geekbrains.geektodolist.toyshop;

/**
 * Класс для запуска приложения для розыгрыша игрушек в магазине
 *
 * @author IvanTretyakov
 * @version 1.0 24.11.2023
 */
public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}

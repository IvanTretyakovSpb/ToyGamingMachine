package ru.geekbrains.geektodolist.toyshop;

/**
 * Интерфейс, описывающий поведение автомата для розыгрыша игрушек в магазине
 *
 * @author IvanTretyakov
 * @version 1.0 24.11.2023
 */
public interface GamingMachineInterface {
    void put(String name, int frequency);

    void letsFun();

    Toy getToy();

    void getAllToys();

    void write(String name);
}

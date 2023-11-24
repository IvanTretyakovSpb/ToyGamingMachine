package ru.geekbrains.geektodolist.toyshop;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Класс, описывающий состояние и поведение автомата для розыгрыша игрушек в магазине
 *
 * @author IvanTretyakov
 * @version 1.0 24.11.2023
 */
public class GamingMachine implements GamingMachineInterface {
    private static int id = 0;
    private Queue<Toy> boxOfToys;
    private Random random;

    public GamingMachine() {
        this.boxOfToys = new PriorityQueue<Toy>();
        this.random = new Random();
    }

    /**
     * Создаёт игрушку с заданными параметрами и добавляет её в автомат для розыгрыша
     *
     * @param name      наименование игрушки
     * @param frequency частота выпадения (вес)
     */
    @Override
    public void put(String name, int frequency) {
        boxOfToys.offer(new Toy(++id, name, frequency));
    }

    @Override
    public void letsFun() {

    }

    @Override
    public Toy getToy() {
        return null;
    }

    /**
     * Выводит на печать информацию о всех загруженных для розыгрыша игрушках
     */
    @Override
    public void getAllToys() {
        System.out.println("В данный момент в розыгрыше участвуют следующие игрушки:");
        for (Toy toy : boxOfToys) {
            System.out.println(toy);
        }
    }

    @Override
    public void write(String name) {

    }
}

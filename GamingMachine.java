package ru.geekbrains.geektodolist.toyshop;

import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Осуществляет выбор в случайном порядке игрушки из имеющегося набора согласно заданным частотам
     *
     * @return экземпляр класса Toy или null при отсутствии доступных для розыгрыша игрушек
     */
    @Override
    public Toy getToy() {
        if (boxOfToys.isEmpty()) {
            return null;
        }
        int totalFrequency = boxOfToys.stream().mapToInt(Toy::getFrequency).sum();
        int randomNumber = random.nextInt(totalFrequency) + 1;
        int cumulativeFrequency = 0;
        for (Toy toy : boxOfToys) {
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber <= cumulativeFrequency) {
                boxOfToys.remove(toy);
                return toy;
            }
        }
        return null;
    }

    /**
     * Выводит на печать информацию о всех загруженных для розыгрыша игрушках
     */
    @Override
    public void getAllToys() {
        if (!this.boxOfToys.isEmpty()) {
            System.out.println("---------------------------------------------------------");
            System.out.println("В данный момент в розыгрыше участвуют следующие игрушки:");
            int i = 0;
            for (Toy toy : boxOfToys) {
                System.out.println(++i + ") " + toy);
            }
            System.out.println("---------------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println("В данный момент в игрушки в автомат не загружены!\n" +
                    "Перед проведением розыгрыша необходимо выполнить загрузку.");
        }

    }

    @Override
    public void write(String name) {
        try (FileWriter fw = new FileWriter("result.txt", true)) {
            fw.write(name);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
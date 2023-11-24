package ru.geekbrains.geektodolist.toyshop;

import java.util.Objects;

/**
 * Класс игрушка, описывающий сущность разыгрываемых в магазине предметов
 *
 * @author IvanTretyakov
 * @version 1.0 24.11.2023
 */
public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("%s (id: %d, частота выпадения: %d)", name, id, frequency);
    }

    @Override
    public int compareTo(Toy o) {
        return this.frequency - o.getFrequency();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        return getId() == toy.getId() && getFrequency() == toy.getFrequency() && Objects.equals(getName(), toy.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFrequency());
    }
}
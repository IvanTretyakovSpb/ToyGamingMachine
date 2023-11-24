package ru.geekbrains.geektodolist.toyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, обеспечивающий в рамках модели MVC взаимодействие с пользователями приложения
 *
 * @author IvanTretyakov
 * @version 1.0 24.11.2023
 */
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    static final String menu = """
            =========================================================
                         Приложение "Розыгрыш игрушек"
            =========================================================
               Главное меню:
            ---------------------------------------------------------
            1. Загрузить игрушки в автомат для розыгрыша.
            2. Показать список всех участвующих в розыгрыше игрушек.
            3. Запустить розыгрыш.
            4. Показать справку.
            5. Закрыть приложение.
            ---------------------------------------------------------
            """;

    int select() {
        System.out.print("Выберите действие: ");
        int result = scanner.nextInt();
        while (!(result == 1 || result == 2 || result == 3 || result == 4 || result == 5)) {
            System.out.print("Некорректный ввод!\nВыберите действие согласно меню: ");
            result = scanner.nextInt();
        }
        return result;
    }

    String askToyName() {
        System.out.print("Введите наименование игрушки: ");
        return scanner.nextLine();
    }

    int askNumber(String message) {
        System.out.printf("Укажите %s: ", message);
        return scanner.nextInt();
    }
}

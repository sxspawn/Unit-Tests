package ru.kovbasa.unittests;

import java.util.ArrayList;
import java.util.Scanner;

import static ru.kovbasa.unittests.product.Products.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> purchases = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию: \n" +
                    "1 - добавить, 2 - показать, 3 - удалить, 4 - найти, 5 - завершить.");
            String input = scanner.nextLine();
            if ("5".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            switch (input) {
                case "1":
                    addProduct(purchases, scanner);
                    break;
                case "2":
                    shoppingListView(purchases);
                    break;
                case "3":
                    delProduct(purchases, scanner);
                    break;
                case "4":
                    searchProduct(purchases, scanner);
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
            }
        }
    }

    private static void delProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Выберите способ удаления: 1 - по номеру, 2 - по названию");
        String deleteMethod = scanner.nextLine();
        scanner.nextLine();
        switch (deleteMethod) {
            case "1":
                delByProductNumber(purchases, scanner);
                break;
            case "2":
                delByProductName(purchases, scanner);
                break;
            default:
                System.out.println("Неверный способ удаления.");
                break;
        }
    }

}
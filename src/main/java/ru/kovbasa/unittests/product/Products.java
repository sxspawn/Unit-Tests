package ru.kovbasa.unittests.product;

import java.util.ArrayList;
import java.util.Scanner;

public class Products {

    public static void addProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите название покупки:");
        String purchase = scanner.nextLine();
        purchases.add(purchase);
        System.out.println("Количество покупок: " + purchases.size());
    }

    public static void shoppingListView(ArrayList<String> purchases) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < purchases.size(); i++) {
            System.out.println((i + 1) + ". " + purchases.get(i));
        }
    }

    public static void delByProductName(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите название покупки:");
        String purchaseName = scanner.nextLine();
        purchases.remove(purchaseName);
    }

    public static void delByProductNumber(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите номер покупки:");
        int purchaseNumber = scanner.nextInt();
        scanner.nextLine();
        purchases.remove(purchaseNumber - 1);
    }

    public static void searchProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите ключевое слово для поиска:");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).toLowerCase().contains(keyword)) {
                if (!found) {
                    System.out.println("Результаты поиска:");
                    found = true;
                }
                System.out.println((i + 1) + ". " + purchases.get(i));
            }
        }
        if (!found) {
            System.out.println("По запросу \"" + keyword + "\" ничего не найдено");
        }
    }
}

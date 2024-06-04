package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Çıkmak için 0, eklemek için 1 kaldırmak için 2 girin");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz seçim");
            }

            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Set<String> uniqueItems = new HashSet<>(groceryList);
        groceryList.clear();
        groceryList.addAll(uniqueItems);
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}

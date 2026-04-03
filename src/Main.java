import exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MyVector vector = null;

        try {
            System.out.println("Спроба створення з відємним capacity");
            vector = new MyVector(-5);
        } catch (InvalidCapacityException e) {
            System.out.println("ПОМИЛКА: " + e.getMessage());
            vector = new MyVector();
            System.out.println("Створено вектор зі стандартним capacity");
        }


        try {
            System.out.println("\nСпроба додати null");
            vector.addToTail(null);
        } catch (NullElementException e) {
            System.out.println("ПОМИЛКА: " + e.getMessage());
        }

        System.out.println("\nEnter first tail el:");
        vector.addToTail(s.nextInt());
        System.out.println("Enter second tail el:");
        vector.addToTail(s.nextInt());
        System.out.println(vector);

        System.out.println("Enter element index to add:");
        int index = s.nextInt();
        System.out.println("Enter element to add:");
        int element = s.nextInt();

        try {
            vector.addOnIndex(index, element);
            System.out.println(vector);
        } catch (InvalidIndexException e) {
            System.out.println("ПОМИЛКА ДОДАВАННЯ: " + e.getMessage());
        }

        System.out.println("Vector capacity: " + vector.getCapacity());
        System.out.println("Vector size: " + vector.getSize());

        System.out.println("\nEnter index to remove element: ");
        int indexToRemove = s.nextInt();


        try {
            vector.remove(indexToRemove);
            System.out.println(vector);
        } catch (EmptyMyVectorException | InvalidIndexException e) {
            System.out.println("ПОМИЛКА ВИДАЛЕННЯ: " + e.getMessage());
        }

        System.out.println("Vector capacity: " + vector.getCapacity());
        System.out.println("Vector size: " + vector.getSize());


        vector.clear();
        System.out.println("\nVector cleared.");

        try {
            System.out.println("Спроба повторного очищення вектора");
            vector.clear();
        } catch (ClearException e) {
            System.out.println("ПОМИЛКА ОЧИЩЕННЯ: " + e.getMessage());
        }

        s.close();
    }
}
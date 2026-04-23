import exceptions.*;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static class MyComparator implements Comparator<Integer>{
        //Compare from biggest to lower
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MyVector<Integer> vector;

        try {
            System.out.println("Спроба створення з від'ємним capacity");
            vector = new MyVector<>(-5);
        } catch (InvalidCapacityException e) {
            System.out.println("ПОМИЛКА: " + e.getMessage());
            vector = new MyVector<>();
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


        // vector.clear();
        // System.out.println("\nVector cleared.");


        System.out.println("\n--- СОРТУВАННЯ ТА ПОРІВНЯННЯ ---");
        MyVector<Integer> otherVector = new MyVector<>();
        otherVector.addToTail(42);
        otherVector.addToTail(15);
        otherVector.addToTail(88);
        otherVector.addToTail(4);
        otherVector.addToTail(23);

        System.out.println("Початковий вектор: " + otherVector);


        otherVector.sort();
        System.out.println("Після виклику sort(): " + otherVector);

        otherVector.sort(new MyComparator());
        System.out.println("Після виклику sort(Comparator): " + otherVector);

        MyVector<Integer> anotherVector = new MyVector<>();
        anotherVector.addToTail(1);
        anotherVector.addToTail(2);

        System.out.println("\nРозмір otherVector: " + otherVector.getSize());
        System.out.println("Розмір anotherVector: " + anotherVector.getSize());

        int compareResult = otherVector.compareTo(anotherVector);
        if (compareResult > 0) {
            System.out.println("otherVector більший за anotherVector");
        } else if (compareResult < 0) {
            System.out.println("otherVector менший за anotherVector");
        } else {
            System.out.println("Вектори рівні за розміром");
        }

        s.close();
    }
}

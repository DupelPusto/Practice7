import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MyVector vector = new MyVector();

        System.out.println("Enter first tail el:");
        int first = s.nextInt();
        vector.addToTail(first);
        System.out.println(vector);

        System.out.println("Enter second tail el:");
        int second = s.nextInt();
        vector.addToTail(second);
        System.out.println(vector);

        System.out.println("Enter third head el:");
        int third = s.nextInt();
        vector.addToHead(third);
        System.out.println(vector);

        System.out.println("Enter fourth head el:");
        int fourth = s.nextInt();
        vector.addToHead(fourth);
        System.out.println(vector);

        System.out.println("Enter element index to add:");
        int index = s.nextInt();
        System.out.println("Enter element to add:");
        int element = s.nextInt();
        vector.addOnIndex(index, element);
        System.out.println(vector);
        System.out.println("Vector capacity: " + vector.getCapacity());
        System.out.println("Vector size: " + vector.getSize());

        System.out.println("Enter index to remove element: ");
        int indexToRemove = s.nextInt();
        vector.remove(indexToRemove);
        System.out.println(vector);
        System.out.println("Vector capacity: " + vector.getCapacity());
        System.out.println("Vector size: " + vector.getSize());

        System.out.println("Enter index to get element:");
        int indexToGet = s.nextInt();
        System.out.println(vector.get(indexToGet));

        vector.clear();
        System.out.println("Vector cleared");
        System.out.println(vector);
        System.out.println("Vector capacity: " + vector.getCapacity());
        System.out.println("Vector size: " + vector.getSize());

    }


}

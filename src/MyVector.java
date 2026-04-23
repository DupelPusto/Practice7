import exceptions.*;

import java.util.Arrays;
import java.util.Comparator;

public class MyVector<T> implements Comparable<MyVector<T>> {
    private T[] values;
    private int size = 0;
    private int defaultCapacity = 10;

    public MyVector() {
        Object[] value = new Object[defaultCapacity];
        this.values = (T[]) value;
    }

    public MyVector(int userCapacity) throws InvalidCapacityException {
        if (userCapacity < 0) throw new InvalidCapacityException("Розмір не може бути відємним");
        Object[] value = new Object[userCapacity];
        this.values = (T[]) value;
    }

    public void addToTail(T value){
        if (value == null){
            throw new NullElementException("Елемент не може бути null");
        }
        checker();
        values[size] = value;
        size++;
    }

    public void addOnIndex(int index, T value){
        if (value == null) throw new NullElementException("Елемент не може бути null");
        if (index < 0 || index > size) throw new InvalidIndexException("Невірний індекс для додавання елемента");

        checker();

        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = value;
        size++;
    }

    public void clear(){
        if (size == 0) throw new ClearException("Вектор вже порожній");
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
        defaultCapacity = 10;
    }

    public void remove(int index) throws EmptyMyVectorException {
        if (size == 0) throw new EmptyMyVectorException("Неможливо видалити елемент. Вектор порожній");
        if (index < 0 || index >= size) throw new InvalidIndexException("Невірний індекс для видалення");

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;
        size--;
    }

    public void addToHead(T value){
        addOnIndex(0, value);
    }

    public T get(int index) throws EmptyMyVectorException{
        if (size == 0) throw new EmptyMyVectorException("Неможливо отримати елемент. Вектор порожній");
        if (index < 0 || index >= size) throw new InvalidIndexException("Невірний індекс для отримання елементу");
        return values[index];
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return values.length;
    }

    private void checker(){
        if (size == values.length) {
            int newCapacity = (values.length == 0) ? 10 : values.length * 2;
            T[] newValues = Arrays.copyOf(values, newCapacity);
            values = newValues;
        }
    }

    @Override
    public String toString() {
        String str = "Values: ";
        for (int i = 0; i < size; i++) {
            str += values[i] + (i < size - 1 ? "; " : "");
        }
        return str;
    }

    //Compare by size
    @Override
    public int compareTo(MyVector<T> o) {
        return Integer.compare(this.size, o.size);
    }


    public void sort() {
        if (size > 1) {
            Object[] mas = Arrays.copyOf(values, size);
            Arrays.sort(mas);
            for (int i = 0; i < size; i++) {
                values[i] = (T) mas [i];
            }
        }
    }

    public void sort(Comparator<? super T> comparator) {
        if (size > 1) {
            Arrays.sort(values, 0,size, comparator);
        }
    }
}

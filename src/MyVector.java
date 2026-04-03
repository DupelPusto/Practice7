import exceptions.*;

import java.util.Arrays;

public class MyVector {
    private Integer[] values;
    private int size = 0;
    private int defaultCapacity = 10;


    public MyVector() {
        this.values = new Integer[defaultCapacity];
    }

    public MyVector(int userCapacity) throws InvalidCapacityException {
        if (userCapacity < 0) throw new InvalidCapacityException("Розмір не може бути відємним");
        this.values = new Integer[userCapacity];
    }

    public void addToTail(Integer value){
        if (value == null){
            throw new NullElementException("Елемент не може бути null");
        }
        checker();
        values[size] = (Integer) value;
        size++;
    }

    public void addOnIndex(int index, Integer value){

        if (value == null) throw new NullElementException("Елемент не може бути null");
        if (index < 0 || index > size) throw new InvalidIndexException("Невірний індекс для додавання елемента");

        checker();

        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = (Integer) value;
        size++;
    }

    public void clear(){

        if (size == 0) throw new ClearException("ектор вже порожній");
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

    public void addToHead(int value){
        addOnIndex(0, (Integer) value);
    }

    public Integer get(int index) throws EmptyMyVectorException{
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
            Integer[] newValues = new Integer[newCapacity];
            for (int i = 0; i < size; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
    }

    @Override
    public String toString() {
        String str = "Values: ";
        for (int i = 0; i < size; i++) {
            if (i == values.length) str += values[i];
            str += values[i] + "; ";
        }
        return str;
    }

}

import java.util.Arrays;

public class MyVector {
    private Integer[] values;
    private int size = 0;
    private int defaultCapacity = 10;


    public MyVector() {
        this.values = new Integer[defaultCapacity];
    }

    public MyVector(int userCapacity) {
        this.values = new Integer[userCapacity];
    }

    public void addToTail(Integer value){
        checker();
        values[size] = value;
        size++;
    }

    public void addOnIndex(int index, Integer value){

        if (index < 0 || index > size) return;

        checker();

        for (int i = size; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = value;
        size++;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }

    public void remove(int index){

        if (index < 0 || index >= size) return;

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        values[size - 1] = null;
        size--;
    }

    public void addToHead(int value){
        addOnIndex(0, value);
    }

    public Integer get(int index){
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
        for (int i = 0; i < values.length; i++) {
            if (i == values.length) str += values[i];
            str += values[i] + "; ";
        }
        return str;
    }
}

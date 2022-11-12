package workingwitharray;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkingWithArray<T> {

    private T[] array;
    private T element;
    private T element1;

    public WorkingWithArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void replaceElementByIndex(int index1, int index2, T[] array) {
        T temp;
        System.out.println("original array");
        System.out.println(Arrays.deepToString(array));
        if (array.length <= index1 || index2 >= array.length) {
            System.out.println("index cannot be larger than array size ");
        } else if (index1 < 0 || index2 < 0) {
            System.out.println("index can't be negative");
        } else {
            if (index1 != index2) {
                for (int i = 0; i < array.length; i++) {
                    if (i == index1) {
                        element = array[i];
                    }
                    if (i == index2) {
                        element1 = array[i];
                    }
                }
                temp = element;
                element = element1;
                element1 = temp;
                for (int i = 0; i < array.length; i++) {
                    if (i == index1) {
                        array[i] = element;
                    }
                    if (i == index2) {
                        array[i] = element1;
                    }
                }
                System.out.println("after change by index");
            }
            System.out.println(Arrays.deepToString(array));
        }
    }

    public <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}



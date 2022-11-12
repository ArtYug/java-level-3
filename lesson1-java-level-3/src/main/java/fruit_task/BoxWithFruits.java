package fruit_task;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxWithFruits<T extends Fruit> {
    private ArrayList<T> fruits;

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public BoxWithFruits(T... fruit) {
        this.fruits = new ArrayList<>(Arrays.asList(fruit));
    }

    public float sum() {
        float result = 0.0f;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    public boolean compare(BoxWithFruits<?> fruitsAnother) {
        return Math.abs(this.sum() - fruitsAnother.sum()) < 0.00001;
    }

    public ArrayList<T> transferFruitFromOneBoxToAnother(BoxWithFruits<T> fruitsAnother) {
        ArrayList<T> copyOfFruitAnother = new ArrayList(Arrays.asList(fruitsAnother.getFruits()));
        fruits.addAll(copyOfFruitAnother);
        copyOfFruitAnother.removeAll(copyOfFruitAnother);
        fruitsAnother.setFruits(copyOfFruitAnother);
        return fruits;
    }

    public ArrayList<T> addFruitsToBox(T fruit) {
        fruits.add(fruit);
        return fruits;
    }
}

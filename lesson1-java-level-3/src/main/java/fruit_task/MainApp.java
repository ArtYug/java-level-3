package fruit_task;

      /*                    Homework 1 java 3
        1. Написать метод, который меняет два элемента массива местами (массив может быть любого
        ссылочного типа);
        2. Написать метод, который преобразует массив в ArrayList;
        3. Задача:
        a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
        фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можно использовать ArrayList;
        d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
        и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
        коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
        равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
        апельсинами;
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
        объекты, которые были в первой;
        g. Не забываем про метод добавления фрукта в коробку.*/

public class MainApp {
    public static void main(String[] args) {
        Apple apple = new Apple("Cameo");
        Apple apple1 = new Apple("Empire ");
        Apple apple2 = new Apple("McIntosh");
        Apple apple3 = new Apple("Golden");
        Orange orange = new Orange("Washington");
        Orange orange1 = new Orange("Tangerine");
        Orange orange2 = new Orange("Seville");
        Orange orange3 = new Orange("Bergamot");
        BoxWithFruits<Orange> orangeBox = new BoxWithFruits<>(orange3, orange2, orange1);
        BoxWithFruits<Orange> orangeBoxWithFruits = new BoxWithFruits<>(orange2, orange3, orange1,orange);
        BoxWithFruits<Apple> appleBoxWithFruits = new BoxWithFruits<>(apple, apple1, apple3,apple2);
        BoxWithFruits<Apple> appleBoxWithFruits1 = new BoxWithFruits<>(apple, apple1, apple3);
        System.out.println(orangeBox.getFruits());
        System.out.println(orangeBox.sum());
        System.out.println(orangeBox.compare(orangeBoxWithFruits));
        orangeBox.transferFruitFromOneBoxToAnother(orangeBoxWithFruits);
        appleBoxWithFruits.addFruitsToBox(apple);
        System.out.println(appleBoxWithFruits.getFruits());
    }
}


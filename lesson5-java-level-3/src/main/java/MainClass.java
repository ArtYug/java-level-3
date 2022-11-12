import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch countDownLatchStart = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch countDownLatchEnd = new CountDownLatch(CARS_COUNT);
    public static Semaphore semaphore = new Semaphore(CARS_COUNT/2);
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(cyclicBarrier, race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            countDownLatchStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            countDownLatchEnd.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
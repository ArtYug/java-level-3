import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final CyclicBarrier cyclicBarrier;
    private static boolean thisISWinner ;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CyclicBarrier cyclicBarrier, Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.countDownLatchStart.countDown();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        MainClass.lock.lock();
        if (!thisISWinner){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + this.name + " - ПОБЕДИТЕЛЬ!!!");
            thisISWinner = true;
        }
        MainClass.lock.unlock();
        MainClass.countDownLatchEnd.countDown();
    }
}
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int count;
    private final int CYCLE_COUNTER = 4;
    private final int SLEEP_TIME = 2500;

    MyCallable() {
        count = 0;
    }

    @Override
    public Integer call() {
        try {
            for (int i = 0; i < CYCLE_COUNTER; i++) {
                Thread.sleep(SLEEP_TIME);
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException err) {
            err.getMessage();
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return count;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new MyCallable());
        tasks.add(new MyCallable());
        tasks.add(new MyCallable());

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("Ррезультаты выполнения всех задач.");

        List<Future<Integer>> answers;
        answers = threadPool.invokeAll(tasks);

        for (Future element : answers) {
            System.out.println(element.get());
        }

        System.out.println();
        System.out.println("Результат от одной задачи. Количество потоков увеличивается, счётчик не сбрасывается.");

        int ans = threadPool.invokeAny(tasks);
        System.out.println(ans);

        threadPool.shutdown();
    }
}

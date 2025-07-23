import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
}

class ThreadPoolTests {
    // 1.JDK普通线程
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    // 2.JDK可执行定时任务的线程池

    /**
     * 封装的休眠函数
     *
     * @param m
     */
    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.JDK普通线程池执行任务
     */
    public void testExecutorService() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("666");
        }
        sleep(10000);
    }
}
package demotest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 17:38
 * @description：
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(()->{
            System.out.println("hi");
        },1,10,TimeUnit.SECONDS);
    }

}

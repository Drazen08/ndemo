package io.nd.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 17:57
 * @description：
 */
public interface EventExecutorGroup extends ScheduledExecutorService,Iterable<EventExecutor> {
}

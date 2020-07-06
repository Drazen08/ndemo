package io.nd.util.concurrent;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 17:57
 * @description：
 */
public interface EventExecutor extends EventExecutorGroup {

    @Override
    EventExecutor next();

    EventExecutorGroup parent();

    boolean inEventLoop();

    boolean inEventLoop(Thread thread);

    <V>Promise<V> newPromise();

    <V> Future<V> newSuccessedFuture();

    <V> Future<V> newFailedFuture();


}

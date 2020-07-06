package io.nd.channel;

import io.nd.util.concurrent.EventExecutorGroup;
import io.nd.util.concurrent.OrderedEventExecutor;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:40
 * @description：
 */
public interface EventLoop extends OrderedEventExecutor, EventLoopGroup {

    @Override
    EventLoopGroup parent();

}

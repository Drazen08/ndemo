package io.nd.channel;

import io.nd.util.concurrent.EventExecutorGroup;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:40
 * @description： 允许注册channel的 {@link EventExecutorGroup}
 */
public interface EventLoopGroup extends EventExecutorGroup {

    @Override
    EventLoop next();

    ChannelFuture register(Channel channel);

    ChannelFuture register(Channel channel, ChannelPromise promise);
}

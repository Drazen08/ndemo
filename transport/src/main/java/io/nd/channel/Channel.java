package io.nd.channel;

import io.nd.buffer.ByteBufAllocator;
import io.nd.util.AttributeMap;

import java.net.SocketAddress;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:09
 * @description：
 */
public interface Channel extends AttributeMap, ChannelOutboundInvoker, Comparable<Channel> {


    EventLoop eventLoop();

    Channel parent();

    ChannelConfig config();

    ChannelId id();

    boolean isOpen();

    boolean isRegister();

    boolean isActive();

    ChannelMetadata metadata();


    SocketAddress localAddress();

    SocketAddress remoteAddress();

    ChannelFuture closeFuture();

    boolean isWriteable();

    UnSafe unsafe();

    ChannelPipeline pipeline();

    ByteBufAllocator alloc();

    ChannelPromise newPromise();

//    ChannelProgressivePromise newProgressivePromise();

    ChannelFuture newSuccessFuture();

    ChannelFuture newFaildFuture();

    ChannelPromise voidPromise();

    ChannelFuture bind(SocketAddress localAddress);

    ChannelFuture connect(SocketAddress remoteAddress);

    ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress);

    ChannelFuture disconnect();

    ChannelFuture close();

    ChannelFuture deregister();


    /**
     * 通过 {@link SocketAddress} 绑定，返回 {@link ChannelFuture }, {@link ChannelPromise} 将会被通知
     * @return
     */
    ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise);

    ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise);

    ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise);

    ChannelFuture disconnect(ChannelPromise promise);

    ChannelFuture close(ChannelPromise promise);

    ChannelFuture deregister(ChannelPromise promise);

    /**
     * 从buffer 中读取数据，
     */
    Channel read();

    ChannelFuture write(Object msg);

    ChannelFuture write(Object msg, ChannelPromise promise);

    /**
     * 清除所有等待中的消息
     */
    Channel flush();

    ChannelFuture writeAndFlush(Object msg,ChannelPromise promise);

    ChannelFuture writeAndFlush(Object msg);

}


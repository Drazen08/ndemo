package io.nd.channel;

import io.nd.util.AttributeMap;

import java.net.SocketAddress;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:09
 * @description：
 */
public interface Channel extends AttributeMap,ChannelOutboundInvoker, Comparable<Channel> {

    ChannelId id();

    boolean isOpen();

    boolean isRegister();

    boolean isActive();

    SocketAddress localAddress();

    SocketAddress remoteAddress();




}

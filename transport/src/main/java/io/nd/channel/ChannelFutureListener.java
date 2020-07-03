package io.nd.channel;

import io.nd.util.concurrent.GenericFutureListener;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:37
 * @description：
 */
public interface ChannelFutureListener extends GenericFutureListener<ChannelFuture> {

    ChannelFutureListener CLOSE = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
        }
    };


}

package io.nd.channel;

import io.nd.util.concurrent.Future;
import io.nd.util.concurrent.GenericFutureListener;
import io.nd.util.concurrent.Promise;


/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:42
 * @description：
 */
public interface ChannelPromise extends ChannelFuture, Promise<Void> {


    Channel channel();

    ChannelPromise setSuccess(Void result);

    boolean trySuccess(Void result);

    ChannelPromise setFailure(Throwable throwable);

    @Override
    ChannelPromise addListener(GenericFutureListener<? extends Future<? super Void>> listener);

    @Override
    ChannelPromise addListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);

    @Override
    ChannelPromise removeListener(GenericFutureListener<? extends Future<? super Void>> listener);

    @Override
    ChannelPromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... listeners);

    @Override
    ChannelPromise sync() throws InterruptedException;

    @Override
    ChannelPromise syncUninterruptibly();

    @Override
    ChannelPromise await() throws InterruptedException;

    @Override
    ChannelPromise awaitUninterruptibly();

}

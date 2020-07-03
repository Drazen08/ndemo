package io.nd.util.concurrent;

import java.util.EventListener;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 10:51
 * @description：
 */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {

    void operationComplete(F future) throws Exception;

}

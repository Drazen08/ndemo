package io.nd.util;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/6 15:09
 * @description：
 */
public interface ResourceLeakTracker<T> {

    void record();

    void record(Object hint);

    boolean close(T t);

}

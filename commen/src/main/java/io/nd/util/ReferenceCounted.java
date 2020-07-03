package io.nd.util;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 14:08
 * @description：
 */
public interface ReferenceCounted {

    int refCnt();

    ReferenceCounted retain();

    ReferenceCounted retain (int increment);

    boolean release();

    boolean release(int decrement);

}

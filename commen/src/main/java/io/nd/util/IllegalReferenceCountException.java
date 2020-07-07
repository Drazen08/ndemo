package io.nd.util;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/6 17:38
 * @description：
 */
public class IllegalReferenceCountException extends IllegalStateException {


    private static final long serialVersionUID = 4469847401721293709L;

    public IllegalReferenceCountException() { }

    public IllegalReferenceCountException(int refCnt) {
        this("refCnt: " + refCnt);
    }

    public IllegalReferenceCountException(int refCnt, int increment) {
        this("refCnt: " + refCnt + ", " + (increment > 0? "increment: " + increment : "decrement: " + -increment));
    }

    public IllegalReferenceCountException(String message) {
        super(message);
    }

    public IllegalReferenceCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalReferenceCountException(Throwable cause) {
        super(cause);
    }

}

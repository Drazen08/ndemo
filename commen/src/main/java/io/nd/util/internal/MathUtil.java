package io.nd.util.internal;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/7 16:46
 * @description：
 */
public class MathUtil {

    private MathUtil() {

    }

    /**
     * 位或运算
     * 只要出现负数 -> throw indexOutBoundException
     * @param index
     * @param fieldLength
     * @param capacity
     * @return
     */
    public static boolean isOutOfBounds(int index, int fieldLength, int capacity) {
        return (index | fieldLength | (index + fieldLength) | (capacity - ((index + fieldLength)))) < 0;
    }

}

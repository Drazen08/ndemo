package io.nd.util;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/1 11:19
 * @description：
 */
public final class ObjectUtil {

    /**
     * 强制非实例化
     */
    private ObjectUtil() {
    }

    public static <T> T checkNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }


}

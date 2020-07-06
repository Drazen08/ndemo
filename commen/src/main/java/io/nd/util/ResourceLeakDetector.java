package io.nd.util;

import io.nd.util.internal.SystemPropertyUtil;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/6 14:29
 * @description：
 */
public class ResourceLeakDetector<T> {
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_LEVEL     = "io.netty.leakDetectionLevel";


    private static final int    TARGET_RECORDS;
    private static final String PROP_TARGET_RECORDS    = "io.netty.leakDetection.targetRecords";
    private static final int    DEFAULT_TARGET_RECORDS = 4;

    private static final Level DEFAULT_LEVEL = Level.SIMPLE;
    private static       Level level;

    static {
        final boolean disabled;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            disabled = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
        } else {
            disabled = false;
        }

        Level defaultLevel = disabled ? Level.DISABLED : DEFAULT_LEVEL;

        // First read old property name
        String levelStr = SystemPropertyUtil.get(PROP_LEVEL_OLD, defaultLevel.name());

        // If new property name is present, use it
        levelStr = SystemPropertyUtil.get(PROP_LEVEL, levelStr);
        Level level = Level.parseLevel(levelStr);

        TARGET_RECORDS = SystemPropertyUtil.getInt(PROP_TARGET_RECORDS, DEFAULT_TARGET_RECORDS);

        ResourceLeakDetector.level = level;
    }

    public enum Level {
        /**
         *
         */
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String levelStr) {
            String trimmedLevelStr = levelStr.trim();
            for (Level l : values()) {
                if (trimmedLevelStr.equalsIgnoreCase(l.name()) || trimmedLevelStr.equals(String.valueOf(l.ordinal()))) {
                    return l;
                }
            }
            return DEFAULT_LEVEL;
        }

    }

    // There is a minor performance benefit in TLR if this is a power of 2.
    static final int DEFAULT_SAMPLING_INTERVAL = 128;

    /**
     * Returns {@code true} if resource leak detection is enabled.
     */
    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    /**
     * Returns the current resource leak detection level.
     */
    public static Level getLevel() {
        return level;
    }

    /**
     * Returns the current resource leak detection level.
     */
    public static void setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level");
        }
        ResourceLeakDetector.level = level;
    }

    private static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T> {

        public DefaultResourceLeak(Object referent) {
            super(referent);
        }

        @Override
        public void record() {

        }

        @Override
        public void record(Object hint) {

        }

        @Override
        public boolean close(T t) {
            return false;
        }
    }

    private static final class Record extends Throwable {

        private static final long serialVersionUID = -1867806963285575488L;


    }
}

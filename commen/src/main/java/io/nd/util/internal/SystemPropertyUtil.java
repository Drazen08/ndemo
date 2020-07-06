package io.nd.util.internal;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 15:53
 * @description：
 */
public class SystemPropertyUtil {

    private SystemPropertyUtil() {
    }

    public static String get(String key) {
        return null;
    }

    public static int getInt(String key, int def) {
        String value = get(key);
        if (value == null) {
            return def;
        }
        value = value.trim();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    public static boolean getBoolean(String key, boolean def) {
        String v = get(key);
        if (v == null) {
            return def;
        }
        v = v.trim().toLowerCase();
        if (v.isEmpty()) {
            return def;
        }
        if ("true".equals(v) || "yes".equals(v) || "1".equals(v)) {
            return true;
        }
        if ("false".equals(v) || "no".equals(v) || "0".equals(v)) {
            return false;
        }

        return def;
    }


    public static String get(String key, String def) {
        if (key == null) {
            throw new NullPointerException("key");
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException(" ");
        }

        String value = null;
        try {
            if (System.getSecurityManager() == null) {
                value = System.getProperty(key);
            } else {
                value = AccessController.doPrivileged(new PrivilegedAction<String>() {
                    @Override
                    public String run() {
                        return System.getProperty(key);
                    }
                });
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        if (value == null) {
            return def;
        }
        return def;
    }


}

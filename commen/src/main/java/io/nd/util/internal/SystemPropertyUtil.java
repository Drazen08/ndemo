package io.nd.util.internal;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author ：sunjx
 * @date ：Created in 2020/7/2 15:53
 * @description：
 */
public class SystemPropertyUtil {

    public static String get(String key) {
        return null;
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

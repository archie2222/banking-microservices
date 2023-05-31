package com.banking.core.util;

import java.util.Map;

public class Util {
    public static String mapToString(Map map, String key) {
        Object o = map.get(key);
        return o == null ? null : String.valueOf(o);
    }
}

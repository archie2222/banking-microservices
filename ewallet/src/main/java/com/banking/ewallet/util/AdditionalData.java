
package com.banking.ewallet.util;

import java.util.LinkedHashMap;

public class AdditionalData extends LinkedHashMap<String, Object> {
    public <T> T get(String key, Class<T> type) {
        if (this.containsKey(key)) {
            LinkedHashMap linkedHashMap = Util.fromJson(String.valueOf(this.get(key)), LinkedHashMap.class);
            return Util.fromJsonMap(linkedHashMap, type);
        } else {
            return null;
        }
    }
}

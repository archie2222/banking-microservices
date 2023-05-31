package com.banking.ewallet.util;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
    private static final Logger log = LoggerFactory.getLogger(Util.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            objectMapper.configure(SerializationFeature.WRAP_EXCEPTIONS, false);
            return objectMapper.writeValueAsString(object);
        } catch (JsonMappingException var2) {
            log.warn("Util Exception (toJson) {}, enable TRACE logging for stack trace", var2.getMessage());
            log.trace("Util Exception (toJson) {}", var2);
            return null;
        } catch (Exception var3) {
            log.warn("Util Exception (toJson)", var3);
            return null;
        }
    }

    public static <T> T fromJson(String string, Class<T> type) {
        try {
            return fromJsonUnCaught(string, type);
        } catch (IOException var3) {
            log.warn("Util Exception (fromJson)", var3);
            return null;
        }
    }

    public static <T> T fromJsonUnCaught(String string, Class<T> type) throws IOException {
        return objectMapper.readValue(string, type);
    }

    public static <T> T fromJsonMap(LinkedHashMap linkedHashMap, Class<T> type) {
        return objectMapper.convertValue(linkedHashMap, type);
    }
}

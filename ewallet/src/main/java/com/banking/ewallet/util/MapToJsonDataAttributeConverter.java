package com.banking.ewallet.util;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Map;

import static com.banking.ewallet.util.Util.fromJson;
import static com.banking.ewallet.util.Util.toJson;

@Converter(
    autoApply = true
)
public class MapToJsonDataAttributeConverter implements AttributeConverter<Map, String> {
    public String convertToDatabaseColumn(Map map) {
        return map == null ? null : toJson(map);
    }
    public Map convertToEntityAttribute(String data) {
        return data == null ? null : fromJson(data, AdditionalData.class);
    }

}

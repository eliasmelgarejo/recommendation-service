package com.ventas.ecommerce.recommendation.shared;

import com.nimbusds.jose.shaded.gson.JsonElement;
import com.nimbusds.jose.shaded.gson.JsonPrimitive;
import com.nimbusds.jose.shaded.gson.JsonSerializationContext;
import com.nimbusds.jose.shaded.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date time adapter.
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> {

    /**
     * serialize
     *
     * @param dateTime dateTime
     * @param type type
     * @param context context
     * @return {@link JsonElement}
     * @see JsonElement
     */
    @Override
    public JsonElement serialize(LocalDateTime dateTime, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // "yyyy-mm-dd hh:mm:ss"
    }
}

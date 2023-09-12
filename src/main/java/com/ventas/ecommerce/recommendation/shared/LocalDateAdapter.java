package com.ventas.ecommerce.recommendation.shared;

import com.nimbusds.jose.shaded.gson.JsonElement;
import com.nimbusds.jose.shaded.gson.JsonPrimitive;
import com.nimbusds.jose.shaded.gson.JsonSerializationContext;
import com.nimbusds.jose.shaded.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date adapter.
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate> {

    /**
     * serialize
     *
     * @param date date
     * @param type type
     * @param context context
     * @return {@link JsonElement}
     * @see JsonElement
     */
    @Override
    public JsonElement serialize(LocalDate date, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
    }

}

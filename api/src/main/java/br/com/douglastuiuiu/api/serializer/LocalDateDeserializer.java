package br.com.douglastuiuiu.api.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author douglastuiuiu
 * @since 04/26/17
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParse, DeserializationContext context) throws IOException, JsonProcessingException {
        return LocalDate.parse(jsonParse.getText());
    }
}
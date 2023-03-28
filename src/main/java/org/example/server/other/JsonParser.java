package org.example.server.other;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonParser {
    private static ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    public static <T> String objectToString (T dataClass) {
        return mapper.writeValueAsString(dataClass);
    }
    @SneakyThrows
    public static <T> T stringToObject (String dataString, Class<T> clazz) {
        return mapper.readValue(dataString, clazz);
    }

    @SneakyThrows
    public static <T> T fileToObject (File file, Class<T> clazz) {
        return mapper.readValue(file, clazz);
    }

}

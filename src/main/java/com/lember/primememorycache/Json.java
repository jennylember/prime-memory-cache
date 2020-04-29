package com.lember.primememorycache;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Optional;
import java.util.TimeZone;

@Slf4j
@UtilityClass
public class Json {

    @Getter
    private static ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setTimeZone(TimeZone.getDefault())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(JsonParser.Feature.ALLOW_COMMENTS);

    @NonNull
    public static <T> String toJsonStringOrFail(@Nullable T object) {
        return toJsonString(object)
                .orElseThrow(() -> new RuntimeException("Failed to write object " + object + " as JSON string"));
    }

    @NonNull
    public static <T> Optional<String> toJsonString(@Nullable T object) {
        if (object != null) {
            try {
                return Optional.of(objectMapper.writerFor(object.getClass()).writeValueAsString(object));
            } catch (JsonProcessingException e) {
                log.error("Failed to write object " + object + " as JSON string", e);
            }
        }
        return Optional.empty();
    }

    @NonNull
    public static <T> T toObjectOrFail(@Nullable String json, @NonNull Class<T> cls) {
        return toObject(json, cls)
                .orElseThrow(() -> new RuntimeException("Failed to parse Json string " + json + " as a member of class " + cls));
    }

    @NonNull
    public static <T> Optional<T> toObject(@Nullable String json, @NonNull Class<T> cls) {
        if (json != null) {
            try {
                return Optional.of(objectMapper.readValue(json, cls));
            } catch (IOException ex) {
                log.error("Failed to parse Json string " + json + " as a member of class " + cls, ex);
            }
        }
        return Optional.empty();
    }

}
package com.sudjoao.screenmatch.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.hint.TypeReference;

public class MapperService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T toObject(String json, Class<T> className) {
        try {
            return objectMapper.readValue(json, className);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

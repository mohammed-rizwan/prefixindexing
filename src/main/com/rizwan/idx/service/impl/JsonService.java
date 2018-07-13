package com.rizwan.idx.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rizwan.idx.service.PersistService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class JsonService implements PersistService {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String,Integer> readData(InputStream stream) throws IOException {
        return objectMapper.readValue(new Scanner(stream).useDelimiter("\\A").next().getBytes(),Map.class);
    }
}

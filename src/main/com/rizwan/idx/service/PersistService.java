package com.rizwan.idx.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface PersistService {

    Map<String,Integer> readData(InputStream stream) throws IOException;

}

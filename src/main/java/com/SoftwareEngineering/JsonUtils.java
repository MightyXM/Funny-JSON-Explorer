package com.SoftwareEngineering;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class JsonUtils {
    // 构建一个静态mapper，用来读写json数据
    private static final ObjectMapper objectMapper = new ObjectMapper();
    // 将json文件读取成JsonNode类型
    public static JsonNode readJsonFile(String filePath) throws IOException{
        return objectMapper.readTree(new File(filePath));
    }
}

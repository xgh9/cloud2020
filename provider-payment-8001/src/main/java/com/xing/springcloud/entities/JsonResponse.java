package com.xing.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
@Data
public class JsonResponse extends HashMap<String, Object> {
    private static String CODE = "code";
    private static String MESSAGE = "message";

    public static JsonResponse error(int code, String msg){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.put(CODE,code);
        jsonResponse.put(MESSAGE,msg);
        return jsonResponse;
    }
    public static JsonResponse success() {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.put(CODE, 200);
        jsonResponse.put(MESSAGE, "success");
        return jsonResponse;
    }
}

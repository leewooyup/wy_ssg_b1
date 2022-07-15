package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private Map<String, String> paramMap;
    private String queryStr;
    private String path;
    private String url;

    public Rq(String cmd) {
        this.url = cmd;
        paramMap = new HashMap<>();
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];
        if (urlBits.length == 2) {
            this.queryStr = urlBits[1];
            String[] paramBits = queryStr.split("&");
            for (String paramBit : paramBits) {
                String[] paramNameAndValue = paramBit.split("=", 2);
                String paramName = paramNameAndValue[0];
                if(paramNameAndValue.length == 2) {
                    String paramValue = paramNameAndValue[1];
                    paramMap.put(paramName, paramValue);
                }
            }

        }
    }

    public int getIntParamValue(String paramName, int defaultValue) {
        if(paramMap.containsKey(paramName) == false) {
            return defaultValue;
        }
        String paramValue = paramMap.get(paramName);
        if (paramValue.length() == 0) {
            return defaultValue;
        }
        return Integer.parseInt(paramValue);
    }

    public String getPath() {
        return path;
    }
}

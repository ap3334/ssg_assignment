package com.jung.prac;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String path;
    private Map<String, String> queryParam = new HashMap<>();

    public Request(String s) {

        String[] bits = s.split("\\?", 2);
        this.path = bits[0];

        if (bits.length == 2) {
            String[] queries = bits[1].split("&");

            for (String query : queries) {
                String[] temp = query.split("=", 2);
                String queryName = temp[0];
                String queryValue = null;

                if (temp.length == 2) {
                    queryValue = temp[1];
                }

                queryParam.put(queryName, queryValue);
            }
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, String> queryParam) {
        this.queryParam = queryParam;
    }

    public String getQueryParamValue(String s, String defaultValue) {

        if (queryParam.containsKey(s)) {
            return queryParam.get(s);
        }

        return defaultValue;

    }





}

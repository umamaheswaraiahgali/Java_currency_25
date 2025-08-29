package com.example.generatetraffice.service;

import com.example.generatetraffice.Entity.DataList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateTrafficeService {
    public Map<String, List> sendRequest(DataList dataList) throws IOException {
        int responseCode = 0;
        String method = dataList.getMethod();
        List<String> successCount = new ArrayList<>();
        List<String> failedCount = new ArrayList<>();
        Map<String, List> responseData = new HashMap<>();
        int count = dataList.getCount();
        System.out.println("executing URLs:......");
        for (String urlstr : dataList.getUrlList()) {
            String urlappend = "http://" + dataList.getHost() + ":" + dataList.getPort();
            urlstr = urlappend + urlstr;
            if (urlstr.contains("<port>")) {
                urlstr = urlstr.replace("<port>", Integer.toString(dataList.getPort()));
            }
            if (urlstr.contains("<host>")) {
                urlstr = urlstr.replace("<host>", dataList.getHost());
            }
            for (int i = 1; i <= dataList.getCount(); i++) {
                try {
                    URI uri = URI.create(urlstr);
                    URL url = uri.toURL();
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(method);
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    responseCode = conn.getResponseCode();

               /*     try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    responseCode >= 200 && responseCode < 300
                                            ? conn.getInputStream()   // Success
                                            : conn.getErrorStream()   // Error response
                            ))) {

                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line).append("\n");
                        }

                        System.out.println("Response Body:\n" + response.toString());
                    }*/
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        String successData = responseCode + ".. " + urlstr;
                        successCount.add(successData);
                    } else if (responseCode == HttpURLConnection.HTTP_BAD_METHOD) {
                        responseCode = executeUrl(urlstr, method);
                        String errorData = responseCode + ".. " + urlstr;
                        failedCount.add(errorData);
                    } else {
                        String errorData = responseCode + ".. " + urlstr;
                        failedCount.add(errorData);
                        continue;
                    }
                } catch (IOException e) {
                    System.out.println("Error accessing: " + urlstr + " -> " + e.getMessage());
                }
            }
        }
        responseData.put("Success Data", successCount);
        responseData.put("Error Data", failedCount);
        System.out.println("executed URLs:......");
        return responseData;
    }

    public int executeUrl(String urlStr, String method) throws IOException {
        int responseCode = 0;
        try {
            URI uri = URI.create(urlStr);
            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            responseCode = conn.getResponseCode();
        } catch (IOException e) {
            System.out.println("Error accessing: " + urlStr + " -> " + e.getMessage());
        }
        return responseCode;
    }

    public Map<String, List> getResponse(DataList dataList) throws IOException {
        Map<String, List> responseData = new HashMap<>();
        List<String> listData = new ArrayList<>();
        String param = "Identify Deep Inherited";
        String encoded = URLEncoder.encode(param, StandardCharsets.UTF_8);
        System.out.println("url " + dataList.getUrl());
        for (int i = 1; i <= dataList.getCount(); i++) {
            URI uri = URI.create(dataList.getUrl() + encoded);
            URL url = uri.toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(dataList.getMethod());
            conn.setConnectTimeout(5000); // 5 sec timeout
            conn.setReadTimeout(5000);
            int responseCode = conn.getResponseCode();
            System.out.println("URL: " + dataList.getUrl() + " | Response Code: " + responseCode);
            listData.add(responseCode + dataList.getUrl());
        }
        responseData.put("Success Data", listData);
        return responseData;
    }
    /* public int postResponsce(String urlString) throws IOException {
     *//* String urlString="http://"+dataList.getHost()+":"+dataList.getPort()+dataList.getUrl();*//*
        System.out.println("url " +urlString);

        URI uri = URI.create(urlString); // safer than new URL(String)
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(5000); // 5 sec timeout
        conn.setReadTimeout(5000);

        int responseCode = conn.getResponseCode();
        System.out.println("URL: " + urlString + " | Response Code: " + responseCode);
        return responseCode;

    }*/
/*    public String dataGenerate(DataList dataList) throws IOException {
        try {
             int port = dataList.getPort();
             String host= dataList.getHost();
             List<String> urlList =dataList.getUrlList();
             StringBuilder respose =new StringBuilder();
            String urlappend="http://"+host+":"+port;
            for (String urlstr : urlList) {
                urlappend=  urlappend+urlstr;
                URI uri = URI.create(urlappend);
                URL url = uri.toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);
                int responseCode = conn.getResponseCode();
                System.out.println("URL: " + urlstr + " | Response Code: " + responseCode);
                respose.append(responseCode);
            }
            return respose.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }*/


}

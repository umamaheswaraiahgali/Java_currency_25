package com.example.generatetraffice.Entity;

import java.util.List;

public class DataList {
    private String url;
    private int port;
    private String method;
    private String host;
    private int count;
    private List<String> urlList;

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public DataList(String url, int port, String method, String host, int count, List<String> urlList) {
        this.url = url;
        this.port = port;
        this.method = method;
        this.host = host;
        this.count = count;
        this.urlList = urlList;
    }

    @Override
    public String toString() {
        return "DataList{" + "url='" + url + '\'' + ", port=" + port + ", method='" + method + '\'' + ", host='" + host + '\'' + ", count=" + count + ", urlList=" + urlList + '}';
    }
}

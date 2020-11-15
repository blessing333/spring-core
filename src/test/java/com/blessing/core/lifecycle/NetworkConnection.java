package com.blessing.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkConnection implements InitializingBean, DisposableBean {
    private String url;

    public NetworkConnection() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void disconnect() {
        System.out.println("disconnect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + message);
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("call network");
    }
}

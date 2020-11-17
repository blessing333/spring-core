package com.blessing.core.web;

import com.blessing.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    //private final MyLogger logger;
    private final ObjectProvider<MyLogger> logger;
    public void logic(String id){
        MyLogger myLogger = logger.getObject();
        myLogger.log("service id : "+id);
    }
}

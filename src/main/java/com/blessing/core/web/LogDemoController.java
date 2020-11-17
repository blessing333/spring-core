package com.blessing.core.web;

import com.blessing.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService service;
    //private final MyLogger logger;
    private final ObjectProvider<MyLogger> logger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL=request.getRequestURL().toString();
        MyLogger myLogger = logger.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        service.logic("testID");
        return "OK";
    }
}

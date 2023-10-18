package com.example.testmetrics.controller;

import com.alibaba.fastjson.JSON;
import com.example.testmetrics.dto.Response;
import com.example.testmetrics.metrics.impl.PutAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GeneralController {

    @Autowired
    private PutAction putAction;

    @GetMapping("/general/putSomething")
    public String putSomething() {
        String param = "hello";
        Response response = (Response) putAction.doAction(param);
        log.info("actionName is {}", putAction.actionName());
        return JSON.toJSONString(response);
    }
}

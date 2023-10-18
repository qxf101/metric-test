package com.example.testmetrics.metrics.impl;

import com.alibaba.fastjson.JSON;
import com.example.testmetrics.dto.Request;
import com.example.testmetrics.dto.Response;
import com.example.testmetrics.metrics.General;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PutAction extends General<Object, Object> {
    @Override
    public Object doAction(Object request) {
        Request newRequest = new Request();
        String param = request.toString();
        newRequest.setParam(param);

        log.info("request param is {}", JSON.toJSONString(newRequest));

        String result = "success";
        Response response = new Response();
        response.setResult(result);
        return response;
    }
}

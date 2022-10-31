package com.example.learnapi.demo.CommonResponse;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseGenerator<T> {
    
    
    public CommonResponse<T> successResponse(T data, String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("200");
        commonResponse.setMessage(message);
        commonResponse.setData(data);

        return commonResponse;
    }


    public CommonResponse<T> failedResponse(String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("500");
        commonResponse.setMessage(message);

        return commonResponse;
    }
}

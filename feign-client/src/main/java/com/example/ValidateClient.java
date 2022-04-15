package com.example;

import com.example.feign.ValidateFeignClient;
import com.example.feign.vo.ClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :leiming5
 * @version :1.0
 * @createTime :2022/3/23 10:22
 */
@Component
public class ValidateClient {

    @Autowired
    private ValidateFeignClient validateFeignClient;

    public String printStr(String label, String value) {
        return validateFeignClient.printStr(label, value);
    }

    public ClassVo testPost(ClassVo result) {
        return validateFeignClient.testPost(result);
    }
}

package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :leiming5
 * @version :1.0
 * @createTime :2022/3/23 10:24
 */
@FeignClient(name = "uniquevalidate", url = "http://localhost:8080")
public interface ValidateFeignClient {

    @GetMapping("test")
     String printStr(String sout) ;
}

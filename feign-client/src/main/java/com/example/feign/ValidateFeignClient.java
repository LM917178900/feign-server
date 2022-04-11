package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author :leiming5
 * @version :1.0
 * @createTime :2022/3/23 10:24
 */
//@FeignClient(name = "uniquevalidate", url = "http://localhost:8080")
@FeignClient(name = "metadata", url = "${metadata.service.url}")
public interface ValidateFeignClient {

    @PostMapping("/test")
    String printStr();
}

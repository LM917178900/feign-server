package com.example.feign;

import com.example.feign.vo.ClassVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author :leiming5
 * @version :1.0
 * @createTime :2022/3/23 10:24
 */
@FeignClient(name = "metadata", url = "${metadata.service.url}")
public interface ValidateFeignClient {

    @GetMapping("/test/get")
    String printStr(@RequestParam("label") String label, @RequestHeader("value") String value);

    @PostMapping("/test/post")
    ClassVo testPost(@RequestBody ClassVo result);
}

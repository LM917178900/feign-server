package com.example.feign.controller;

import com.example.feign.vo.ClassVo;
import org.springframework.web.bind.annotation.*;


/**
 * @description: XxxController
 * @author: leiming5
 * @date: 2022/2/22 20:21
 */
@RestController
public class XxxController {

    @GetMapping("/test/get")
    public String printStr(@RequestParam("label") String label, @RequestHeader("value") String value) {
        System.out.println("get only");
        return label + ":" + value;
    }

    @PostMapping("/test/post")
    public ClassVo testPost(@RequestBody ClassVo result) {
        System.out.println("post only");
        return result;
    }
}

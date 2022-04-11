package com.example.feign.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: XxxController
 * @author: leiming5
 * @date: 2022/2/22 20:21
 */
@RestController
public class XxxController {

    @PostMapping("/test")
    public String printStr() {

        System.out.println("post only");

        return "post only";
    }
}

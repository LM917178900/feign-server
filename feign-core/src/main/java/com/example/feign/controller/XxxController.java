package com.example.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description: XxxController
 * @author: leiming5
 * @date: 2022/2/22 20:21
 */
@RestController
public class XxxController {

    @GetMapping("test")
    public String printStr(String sout) {

        System.out.println(sout);

        return sout;
    }
}

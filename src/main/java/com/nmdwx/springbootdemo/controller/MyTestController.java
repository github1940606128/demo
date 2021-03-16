package com.nmdwx.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangxiao
 * @date: 2021-03-12 15:55
 **/
@RestController
@RequestMapping("/test")
public class MyTestController {

    @GetMapping("/fun")
    public String fun(){
        return "";
    }
}

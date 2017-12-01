package com.cafebabe.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *     通过该路径引入js时，可以不写版本号：
 *     src="/webjarslocator/jquery/jquery.js"
 * </pre>
 * <p>
 * <p>createDate: 2017/10/19 11:48
 * <p>blog: <a href=http://www.cnblogs.com/koala2016/>喝咖啡的考拉</a>
 * <p>author: 李德华 
 * <p>version: 1.0 2017/10/19
 */
@Controller
public class CafeBabeController {


    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
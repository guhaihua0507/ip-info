package com.ghh.ipcheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApplicationController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ipInfo")
    public String checkIPAddress(HttpServletRequest request, @RequestParam String callback) {
        String ipAddress = request.getRemoteAddr();
        String url = "http://whois.pconline.com.cn/ipJson.jsp?ip=" + ipAddress + "&callback=" + callback;
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}

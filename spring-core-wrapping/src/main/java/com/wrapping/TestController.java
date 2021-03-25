package com.wrapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("test")
@RestController
public class TestController {

    @GetMapping("/data")
    public Map<String, Object> data() {
        Map<String,Object> res = new HashMap<String, Object>();
        res.put("name","xiaoming");
        res.put("age","30");
        return res;
    }
}

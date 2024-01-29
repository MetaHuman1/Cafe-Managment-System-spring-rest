package com.inn.cafe.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(path = "/dashboard")
public interface DashBoardRest {

    @GetMapping(path = "/details")
    ResponseEntity<Map<String, Object>> getCount();
}








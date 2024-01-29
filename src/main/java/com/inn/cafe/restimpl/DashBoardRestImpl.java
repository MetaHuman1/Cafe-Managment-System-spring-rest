package com.inn.cafe.restimpl;

import com.inn.cafe.rest.DashBoardRest;
import com.inn.cafe.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class DashBoardRestImpl implements DashBoardRest {

    @Autowired
    DashBoardService dashBoardService;

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        return dashBoardService.getCount();
    }
}







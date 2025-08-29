package com.example.generatetraffice.controller;

import com.example.generatetraffice.Entity.DataList;
import com.example.generatetraffice.service.GenerateTrafficeService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController()
@RequestMapping("/api")
public class GenerateTrafficeController {

    private final GenerateTrafficeService generateTrafficeService = new GenerateTrafficeService();

    @GetMapping("/callHello")
    public String gettingMessage() throws IOException {
        return "Welcome.....!";
    }

    @PostMapping("/submitPostRequest")
    public Map<String, List> submitRequest(@RequestBody DataList dataList) throws IOException {
        return generateTrafficeService.sendRequest(dataList);
    }

    @PostMapping("/executeUrl")
    public Map<String, List> executeUrl(@RequestBody DataList dataList) throws IOException {
        return generateTrafficeService.getResponse(dataList);
    }

}

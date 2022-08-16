package com.huynhuyn25.projectbanggia.controller;


import com.google.gson.JsonObject;
import com.huynhuyn25.projectbanggia.model.StockInfo;
import com.huynhuyn25.projectbanggia.service.IStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickfix.ConfigError;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stockInfo")
public class StockInfoController {
    @Autowired
    private IStockInfoService iStockInfoService;

    @GetMapping()
    public List<StockInfo> getStockInfo() throws ConfigError, IOException, InvalidMessage, FieldNotFound {
        return iStockInfoService.getStockInfo();
    }}

package com.huynhuyn25.projectbanggia.service;

import com.google.gson.JsonObject;
import quickfix.ConfigError;
import quickfix.FieldNotFound;
import quickfix.InvalidMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IStockInfoService {
    public List<String> getStockInfo() throws ConfigError, IOException, InvalidMessage, FieldNotFound;
}

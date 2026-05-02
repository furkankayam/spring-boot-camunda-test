package com.furkankayam.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanApprovalController {

    private static final String PROCESS_ID = "LoanApprovalProcess";

    @Autowired
    private RuntimeService runtimeService;

    // Camunda: Asenkron yuruyecek islemler icin kullanilir response beklemek mantiksiz.
    @GetMapping("/approveloanrequest/{amount}")
    public String approvalLaonReqest(@PathVariable String amount) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amount);
        runtimeService.startProcessInstanceByKey(PROCESS_ID, payload);
        return String.format("ID: %s has been started.", PROCESS_ID);
    }
}

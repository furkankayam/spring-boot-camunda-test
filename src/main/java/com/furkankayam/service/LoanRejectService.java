package com.furkankayam.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanRejectService implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(LoanRejectService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String amount = (String) execution.getVariable("amount");
        execution.setVariable("status", "REJECTED");
        log.info("{} TL loan request has been rejected!", amount);
    }
}

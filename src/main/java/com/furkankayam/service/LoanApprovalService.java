package com.furkankayam.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoanApprovalService implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(LoanApprovalService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String amount = (String) execution.getVariable("amount");
        execution.setVariable("status", "APPROVED");
        log.info("{} TL loan request has been approved!", amount);
    }
}

package com.furkankayam.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompleteRequestService implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(LoanApprovalService.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String status = (String) execution.getVariable("status");
        if(status.equals("APPROVED")) {
            log.info("Process has been completed! | Staus: {}", status);
        } else if (status.equals("REJECTED")) {
            log.info("Process has been completed! | Staus: {}", status);
        } else {
            log.info("Process has been failed! | Staus: {}", status);
        }
    }
}

package com.cs.jeff.apmagent;

import co.elastic.apm.api.CaptureTransaction;

public class APMAgentCaptureTransaction {

    @CaptureTransaction
    public void doCaptureTransaction() {
        System.out.println("In APMAgentCaptureTransaction.doCaptureTransaction");
    }

}


package com.cs.jeff.apmagent;

import co.elastic.apm.api.CaptureSpan;

public class APMAgentCaptureSpan {
    @CaptureSpan
    public void doCaptureSpan() {
        System.out.println("In APMAgentCaptureSpan.doCaptureSpan");
    }
}


package com.cs.jeff.apmagent.servlet.service;

import java.math.BigDecimal;

public class CPUUsageService {
    private int logLoop=1000;
    private int count=0;
    public String consumeCpu(final int loops,final int logLoop) {
        this.logLoop = logLoop;
        long startTime = System.currentTimeMillis();
        try {

            for(int i=0;i<loops;i++) {
                BigDecimal  b1= new BigDecimal(i);
                BigDecimal  b2= new BigDecimal(i);
                BigDecimal b3 = b1.multiply(b2);
                printLog(b3);
            }

        }catch (Exception e) {
            return e.toString();
        }
        long endTime = System.currentTimeMillis();
        return "CPU Usage Test Finish,it take ["+((endTime-startTime)/1000) +"] second.";
    }
    private void printLog(final Object msg) {
        if(this.count>this.logLoop) {
            System.out.println(msg.toString());
            this.count=0;
        }
    }
}

package com.cs.jeff.apmagent.servlet.service;

import java.math.BigDecimal;

public class CPUUsageService {
    public String consumeCpu(final int loops) {
        long startTime = System.currentTimeMillis();
        try {

            for(int i=0;i<loops;i++) {
                BigDecimal  b1= new BigDecimal(i);
                BigDecimal  b2= new BigDecimal(i);
                BigDecimal b3 = b1.multiply(b2);
                System.out.println(b3);
            }

        }catch (Exception e) {
            return e.toString();
        }
        long endTime = System.currentTimeMillis();
        return "CPU Usage Test Finish,it take ["+((endTime-startTime)/1000) +"] second.";
    }

}

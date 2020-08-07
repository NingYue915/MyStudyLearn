package com.cs.jeff.apmagent.servlet.service;

import java.io.InputStream;

import org.w3c.dom.Document;

import com.cs.jeff.apmagent.util.APMAgentUtil;

public class MemoryUsageService{
    public String consumeMemory(final int times) {
        String fileName="memory/MemoryUsage-Test.XML";
        long startTime = System.currentTimeMillis();
        try {

            for(int i=0;i<times;i++) {
                consumeMemorySingle(fileName);
            }

        }catch (Exception e) {
            return e.toString();
        }
        long endTime = System.currentTimeMillis();
        return "Memory Usage Test Finish,it take ["+((endTime-startTime)/1000) +"] second.";
    }

    public void consumeMemorySingle(final String fileName) {
        try(InputStream is = APMAgentUtil.getInputStreamByResourceFile(fileName,null)){
            Document domDocument = APMAgentUtil.xmlStreamToDom(is);
            String xmlStr = APMAgentUtil.convertToString(domDocument);
            System.out.println("Read "+fileName+"Complete,file size is "+xmlStr.length());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

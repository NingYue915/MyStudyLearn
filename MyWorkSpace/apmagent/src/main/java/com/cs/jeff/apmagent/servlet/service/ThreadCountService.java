package com.cs.jeff.apmagent.servlet.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadCountService {
    private static final int SEED = 5000;

    public String consumeThread(final int threadNumber,final int threadPool) {
        long startTime = System.currentTimeMillis();
        try {
            ExecutorService threadPoolService = Executors.newFixedThreadPool(threadPool);
            for(int i=0;i<threadNumber;i++) {
                int idleTime = (int)(Math.random()*ThreadCountService.SEED);
                threadPoolService.execute(new TreadCountExecutor(idleTime));
            }
            chkSubThreadTaskStauts(threadPoolService);

        }catch (Exception e) {
            return e.toString();
        }
        long endTime = System.currentTimeMillis();
        return "Thread Count Test Finish,it take ["+((endTime-startTime)/1000) +"] second.";

    }
    private void chkSubThreadTaskStauts(final ExecutorService threadPool) {
        try {
            threadPool.shutdown();
            ThreadPoolExecutor tp = (ThreadPoolExecutor) threadPool;
            while (!threadPool.isTerminated()) {
                System.out.println("Complete thread num=" + tp.getCompletedTaskCount());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class TreadCountExecutor implements Runnable {

    private int sleetTime = 0;

    public TreadCountExecutor(final int idleTime) {

        this.sleetTime = idleTime;
    }

    @Override
    public void run() {

        try {
            System.out.println("Thread start,Thread name:"+Thread.currentThread().getName());
            Thread.sleep(this.sleetTime);
            System.out.println("Thread  End ,Thread name:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

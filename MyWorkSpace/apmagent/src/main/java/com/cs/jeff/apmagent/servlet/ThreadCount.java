package com.cs.jeff.apmagent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.jeff.apmagent.servlet.service.ThreadCountService;
import com.cs.jeff.apmagent.util.APMAgentUtil;


public class ThreadCount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        String numberString = request.getParameter("thread.number");
        String poolString = request.getParameter("thread.pool");
        int threadNumber = 200;
        int threadPool = 200;
        try {
            threadNumber = Integer.parseInt(numberString);
            threadPool  = Integer.parseInt(poolString);
        }catch (Exception e) {
        }
        String reString = new ThreadCountService().consumeThread(threadNumber,threadPool);
        APMAgentUtil.sendResponse(reString,request,response);
    }
}

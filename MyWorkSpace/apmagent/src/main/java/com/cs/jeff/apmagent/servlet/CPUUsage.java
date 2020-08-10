package com.cs.jeff.apmagent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.jeff.apmagent.servlet.service.CPUUsageService;
import com.cs.jeff.apmagent.util.APMAgentUtil;


public class CPUUsage extends HttpServlet {
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
        String loops = request.getParameter("cpu.loop");
        String logLoops= request.getParameter("log.loop");
        int loop = 100000000;
        int logLoop = 1000;
        try {
            loop = Integer.parseInt(loops);
        }catch (Exception e) {
        }
        try {
            logLoop = Integer.parseInt(logLoops);
        }catch (Exception e) {
        }
        String reString = new CPUUsageService().consumeCpu(loop,logLoop);
        APMAgentUtil.sendResponse(reString,request,response);
    }
}

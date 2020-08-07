package com.cs.jeff.apmagent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.jeff.apmagent.servlet.service.MemoryUsageService;
import com.cs.jeff.apmagent.util.APMAgentUtil;


public class MemoryUsage extends HttpServlet {
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
        String loops = request.getParameter("memory.loop");
        int times = 1;
        try {
            times = Integer.parseInt(loops);
        }catch (Exception e) {
        }
        String reString = new MemoryUsageService().consumeMemory(times);
        APMAgentUtil.sendResponse(reString,request,response);
    }
}

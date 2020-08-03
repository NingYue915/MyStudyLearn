package com.cs.jeff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.jeff.service.GetEnvParameterService;

/**
 * Servlet implementation class HelloWorld
 */

public class GetEnvParameter extends HttpServlet {
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
        String nameString = request.getParameter("env.name");
        GetEnvParameterService service = new GetEnvParameterService();
        response.getWriter().append(service.getEvnValue(nameString)).append(request.getContextPath());
    }

}

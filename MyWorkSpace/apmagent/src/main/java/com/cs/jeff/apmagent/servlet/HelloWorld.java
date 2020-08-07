package com.cs.jeff.apmagent.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.jeff.apmagent.servlet.service.HelloWorldService;
import com.cs.jeff.apmagent.util.APMAgentUtil;

/**
 * Servlet implementation class HelloWorld
 */

public class HelloWorld extends HttpServlet {
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
        String nameString = request.getParameter("user.name");
        String reString = new HelloWorldService().sayHello(nameString);
        response.getWriter().append(reString).append(request.getContextPath());
    }

    @Override
    public void init(final ServletConfig config) throws ServletException {

        // TODO Auto-generated method stub
        super.init(config);
        initSystemProperty();
    }

    @Override
    public void init() throws ServletException {

        // TODO Auto-generated method stub
        super.init();
        initSystemProperty();
    }

    private void initSystemProperty() {
        APMAgentUtil.setSystemId();
    }


}

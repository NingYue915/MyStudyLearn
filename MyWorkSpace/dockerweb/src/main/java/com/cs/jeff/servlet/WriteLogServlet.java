package com.cs.jeff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cs.jeff.consts.DockerWebConst;

/**
 * Servlet implementation class HelloWorld
 */

public class WriteLogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        String logName = request.getParameter("log.name");
        String logValue = request.getParameter("log.value");
        logName = StringUtils.isEmpty(logName)?DockerWebConst.DEFAULT_LOGGER:logName;
        Logger logger = LoggerFactory.getLogger(logName);
        logger.debug(logValue);
        response.getWriter().append("Write Log OK!").append(request.getContextPath());
    }


}

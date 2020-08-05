package com.cs.jeff.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class HelloWorld
 */

public class WriteFileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        String logPath = request.getParameter("log.path");
        String logFile = request.getParameter("log.file");
        String logValue = request.getParameter("log.value");
        logValue = StringUtils.isEmpty(logValue) ? "" : logValue;
        logValue = logValue + "\r\n";
        File file = new File(logPath + File.separator + logFile);
        File path = new File(logPath);
        if (!path.exists()) {
            path.mkdirs();
        }
        try (FileOutputStream os = new FileOutputStream(file, true)) {
            os.write(logValue.getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            response.getWriter().append("Write File Not OK\r\n" + e.toString()).append(request.getContextPath());
        }

        response.getWriter().append("Write File OK!").append(request.getContextPath());

    }


}

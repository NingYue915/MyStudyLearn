package com.cs.jeff.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */

public class WriteFileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try {
            String logPath = request.getParameter("log.path");
            String logFile = request.getParameter("log.file");
            String logValue = request.getParameter("log.value");
            File file = new File(logPath+File.separator+logFile);
            try(FileOutputStream os =new FileOutputStream(file)){
                os.write(logValue.getBytes());
            }
        }catch (Exception e) {
            response.getWriter().append(e.toString()).append(request.getContextPath());
        }
        response.getWriter().append("Write File OK!").append(request.getContextPath());

    }


}

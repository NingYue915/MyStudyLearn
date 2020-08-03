package com.cs.jeff.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cs.jeff.util.LogBackUtil;

/**
 * Servlet implementation class HelloWorld
 */

public class AppInitializeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void init(final ServletConfig config) throws ServletException {

        initSystemLoging();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        initSystemLoging();
    }
    private void initSystemLoging() {
        try {
            LogBackUtil.initLogFrameworkContext();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}

package com.cs.jeff.apmagent.servlet.service;


public class HelloWorldService {
    public String sayHello(final String name) {
        if(name==null) {
            return "Hello World!";
        }
        return "Hello "+name;
    }

}

package com.cs.jeff.service;

import com.cs.jeff.util.DockerUtil;

public class GetEnvParameterService {
    public String getEvnValue(final String name) {
        String respString = "Start get value for ["+name+"]\r\n";
        String value = DockerUtil.getEnvVariable(name);
        respString+="Get value from System Evn:"+value;
        value = DockerUtil.getSystemPropety(name);
        respString+="Get value from System Property:"+value;
        return respString;

    }

}

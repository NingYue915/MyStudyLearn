package com.cs.jeff.util;

import java.util.UUID;

public class DockerUtil {
    public static void setSystemId() {

        String uuidString = UUID.randomUUID().toString();
        System.setProperty("SYS_ID", uuidString);
    }
    public static String getSystemId() {
        return System.getProperty("SYS_ID");
    }

}

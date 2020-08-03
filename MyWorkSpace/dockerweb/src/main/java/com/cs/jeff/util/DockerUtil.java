package com.cs.jeff.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.cs.jeff.consts.DockerWebConst;

public class DockerUtil {
    public static void setSystemId() {

        String uuidString = UUID.randomUUID().toString();
        System.setProperty("SYS_ID", uuidString);
    }
    public static String getSystemId() {
        return System.getProperty("SYS_ID");
    }

    public static String getEnvVariable(final String name) {

        return System.getenv(name);
    }

    public static String getSystemPropety(final String name) {

        return System.getProperty(name) ;
    }
    public static String getSystemTempFolder() {
        String value = getSystemEnvVariable(DockerWebConst.USER_DIR);
        return StringUtils.isEmpty(value)?getSystemEnvVariable(DockerWebConst.USER_HOME):value;
    }
    public static String getSystemEnvVariable(final String name) {

        String value = getEnvVariable(name);
        return StringUtils.isEmpty(value)?getSystemPropety(name):value;
    }
    public static InputStream getInputStreamByResourceFile(final String resourceName, final Class<?> cls) {

        Class<?> class1 = cls == null ? DockerUtil.class : cls;
        return class1.getClassLoader().getResourceAsStream(resourceName);
    }

    public static String getFileInputStreamContent(final InputStream is,final Charset charet) {
        String str = "";
        try {
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            str = result.toString(charet.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

package com.cs.jeff.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.cs.jeff.consts.DockerWebConst;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

public class LogBackUtil {

    public static void initLogFrameworkContext() {
        String logConfigFile = "config/logback.xml";
        try(InputStream is = DockerUtil.getInputStreamByResourceFile(logConfigFile,null)){
            initLogFrameworkContext(is);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void initLogFrameworkContext(final InputStream configInputSteam) {

        try {
            InputStream is = configInputSteam;
            if (is == null) {
                return;
            }
            String logPath = DockerUtil.getSystemEnvVariable(DockerWebConst.LOG_PATH);
            logPath = StringUtils.isEmpty(logPath)?DockerUtil.getSystemTempFolder():logPath;
            if (!StringUtils.isEmpty(logPath)) {
                String str =  DockerUtil.getFileInputStreamContent(is, StandardCharsets.UTF_8);
                if (str.indexOf("{LOG_PATH}") >= 0) {
                    logPath = logPath.replaceAll("\\\\+", "/");
                    str = str.replaceAll("\\{LOG_PATH\\}", logPath);
                    is = new ByteArrayInputStream(str.getBytes());
                }
            }
            parseXML(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(final InputStream is) throws Exception {

        try (InputStream inputStrem = is) {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(loggerContext);
            loggerContext.reset();
            joranConfigurator.doConfigure(inputStrem);
            StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
        }
    }
}


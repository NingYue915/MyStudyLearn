package com.cs.jeff.apmagent.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import co.elastic.apm.agent.shaded.stagemonitor.util.StringUtils;

public class APMAgentUtil {
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

    public static String getSystemEnvVariable(final String name) {

        String value = getEnvVariable(name);
        return StringUtils.isEmpty(value)?getSystemPropety(name):value;
    }
    public static InputStream getInputStreamByResourceFile(final String resourceName, final Class<?> cls) {

        Class<?> class1 = cls == null ? APMAgentUtil.class : cls;
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
    public static Document xmlStreamToDom(final InputStream is) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setExpandEntityReferences(false);
        factory.setIgnoringComments(false);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(is);
    }
    public static String convertToString(final Node nNode) throws TransformerFactoryConfigurationError, TransformerException {

        if (nNode == null) {
            throw new IllegalArgumentException();
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        if (transformer != null) {
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(nNode), new StreamResult(sw));
            return sw.toString();
        }
        return "";
    }
    public static String buildResponseString(final String respMsg,final HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"responseMessage\":");
        sb.append("\"").append(respMsg).append("\",");
        sb.append("\"contextPath\":");
        sb.append("\"").append(request.getContextPath()).append("\",");
        sb.append("\"requestPath\":");
        sb.append("\"").append(request.getServletPath()).append("\"");
        sb.append("}");
        return sb.toString();
    }

    public static void sendResponse(final String respMsg,final HttpServletRequest request,final HttpServletResponse response) {
        try(PrintWriter pw=response.getWriter()){
            String msg = buildResponseString(respMsg, request);
            response.setContentType("application/json");
            pw.append(msg);
            pw.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

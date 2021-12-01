package com.hengheng.util.omp4j.utils;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.SneakyThrows;

import java.util.Arrays;

/**
 * @author panhb
 */
public class XmlUtils {

    public static String obj2Xml(Object object){
        //解决下划线_变__问题
        XStream xStream = new XStream(new DomDriver(null,new XmlFriendlyNameCoder("_-", "_")));
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(object);
        String[] infos = xml.split("\n");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(infos).forEach(info -> sb.append(info.trim()));
        xml = sb.toString();
        return xml;
    }

    @SneakyThrows
    public static String xml2Json(String xml) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTrimSpaces(true);
        try {
            return xmlSerializer.read(xml).toString();
        }catch (Exception e){
            throw new OmpUtilsException("xml转json错误:"+e.getMessage(), e);
        }
    }

}

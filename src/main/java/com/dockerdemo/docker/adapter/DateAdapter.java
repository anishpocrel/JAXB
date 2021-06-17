package com.dockerdemo.docker.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anish Pokhrel
 * @version 1.0.0
 * @since 1.0.0 - 2021/06/17 11:40
 */
public class DateAdapter extends XmlAdapter<String, Date> {


    @Override
    public Date unmarshal(String s) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}

package com.demo.model;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerProperty extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //super.setAsText(text);
        try {
            //转换对象，能过setValue方法重新赋值
            this.setValue(sdf.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

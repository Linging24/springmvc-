package com.linging.config;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

//String(1999-01-01) 转 日期格式
//自定义类型转换器，需要实现现Converter接口
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("字符串转日期，出现错误！！");
        }
    }
}
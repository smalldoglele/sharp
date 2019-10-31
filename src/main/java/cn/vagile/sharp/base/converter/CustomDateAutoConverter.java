package cn.vagile.sharp.base.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 自定义日期转化类
 */
public class CustomDateAutoConverter implements Converter<String, Date> {
    //yyyy-MM-dd
    private String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";


    @Override
    public Date convert(String text) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!Pattern.matches(datePattern, text)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            return sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}


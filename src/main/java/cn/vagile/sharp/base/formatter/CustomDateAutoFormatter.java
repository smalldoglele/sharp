package cn.vagile.sharp.base.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 自定义Date日期转化类
 */
public class CustomDateAutoFormatter implements Formatter<Date> {
    //yyyy-MM-dd
    private String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat sdf = null;
        if (Pattern.matches(datePattern, text)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");

        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return sdf.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return Long.toString(object.getTime());
    }


}


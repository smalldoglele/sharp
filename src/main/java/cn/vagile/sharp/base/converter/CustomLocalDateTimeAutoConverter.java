package cn.vagile.sharp.base.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 自定义日期转化类
 */
public class CustomLocalDateTimeAutoConverter implements Converter<String, LocalDateTime> {
    //yyyy-MM-dd
    private String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";

    @Override
    public LocalDateTime convert(String text) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (Pattern.matches(datePattern, text)) {
            return LocalDateTime.parse(text + " 00:00:00", dtf);
        } else {
            return LocalDateTime.parse(text, dtf);
        }
    }
}


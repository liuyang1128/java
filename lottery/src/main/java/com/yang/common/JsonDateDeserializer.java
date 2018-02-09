package com.yang.common;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Package:com.yixin.ndss.utils.common
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:29
 */
@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {
    private final static Logger logger = LoggerFactory.getLogger(JsonDateDeserializer.class);

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Date date = null;
        String text = jp.getText();
        if (StringUtils.isBlank(text)){
            return  date;
        }
        try {
            date = CommonUtil.parseDate(text, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            try {
                date = CommonUtil.parseDate(text, "yyyy-MM-dd");
            } catch (ParseException e1) {
                if (jp.getText() != null) {
                    try {
                        Long time = Long.valueOf(text);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(time);
                        date = calendar.getTime();
                    } catch (Exception e2) {
                        logger.error(e2.getMessage(), e2);
                    }
                } else {
                    logger.error(e1.getMessage(), e1);
                }
            }
        }
        return date;
    }
}

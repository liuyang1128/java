package com.yang.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Package:com.yixin.ndss.utils.common
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:23
 */
@Component
public class JsonDateTimeSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, com.fasterxml.jackson.core.JsonProcessingException {

        jsonGenerator.writeString(CommonUtil.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
    }
}

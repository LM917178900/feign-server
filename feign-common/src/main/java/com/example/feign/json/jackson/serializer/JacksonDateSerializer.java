/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.feign.json.jackson.serializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.example.feign.util.DateUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * <p>
 * Jackson Date反序列化器
 * </p>
 *
 * @author geekidea
 * @date 2018-11-08
 */
public class JacksonDateSerializer extends JsonSerializer<Date> implements ContextualSerializer {
    private final String format;
    private final String timeZone;

    private JacksonDateSerializer(final String format,final String timeZone) {
        this.format = format;
        this.timeZone = timeZone;
    }

    public JacksonDateSerializer() {
        this.format = DateUtil.formatStr_yyyyMMddHHmmss;
//        this.format = DateUtil.formatStr_MMddyyyyHHmm;
        this.timeZone = TimeZone.getDefault().getID();
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String string = null;
        if (date != null) {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            sf.setTimeZone(TimeZone.getTimeZone(timeZone));
            string = sf.format(date);
        }
        jsonGenerator.writeString(string);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        final JsonFormat jsonFormat = beanProperty.getMember().getAllAnnotations().get(JsonFormat.class);
        if (jsonFormat == null) {
            return this;
        }
        return new JacksonDateSerializer(jsonFormat.pattern(), jsonFormat.timezone());
    }
}

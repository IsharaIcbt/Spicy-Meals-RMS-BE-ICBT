/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 11:09 AM
 */
package com.ceyentra.sm.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {

    public CustomOauthExceptionSerializer() {
        super(com.ceyentra.sm.exception.CustomOauthException.class);
    }

    @Override
    public void serialize(com.ceyentra.sm.exception.CustomOauthException value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeBooleanField("success", false);
        jsonGenerator.writeObjectField("message", value.getMessage());
        jsonGenerator.writeEndObject();
    }

}

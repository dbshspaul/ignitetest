package com.jac.travels.spring.controller;

import com.googlecode.protobuf.format.JsonFormat;
import com.jac.travels.protobuf.Property;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * created by My System on 14-Dec-17
 **/
public class ControllerTest {

    @Test
    public void saveProperty() {
        InputStream responseStream = null;
        String jsonOutput = null;
        try {
            responseStream = executeHttpRequest("http://localhost:8080/property/1");
            jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("{\"propertyId\": 1,\"cutOffTime\": 14,\"name\": \"Hotel 37\",\"starRating\": 4.0,\"status\": 1}",
                jsonOutput);
    }

    private InputStream executeHttpRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(request);
        return httpResponse.getEntity().getContent();
    }

    private String convertProtobufMessageStreamToJsonString(InputStream protobufStream) throws IOException {
        JsonFormat jsonFormat = new JsonFormat();
        Property.PropertyRequestProto propertyRequestProto = Property.PropertyRequestProto.parseFrom(protobufStream);
        return jsonFormat.printToString(propertyRequestProto);
    }
}
package com.jac.travels.spring.controller;

import com.googlecode.protobuf.format.JsonFormat;
import com.jac.travels.protobuf.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * created by My System on 14-Dec-17
 **/
public class ControllerTest {

    @Test
    public void saveProperty() {
        InputStream responseStream = null;
        String jsonOutput = null;
        try {
            responseStream = executeHttpRequest("http://localhost:8080/property/1?tenant_id=45a");
            jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
            System.out.println(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream executeHttpRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(request);
        return httpResponse.getEntity().getContent();
    }

    private String convertProtobufMessageStreamToJsonString(InputStream protobufStream) throws IOException {
        JsonFormat jsonFormat = new JsonFormat();
        Response.PropertyResponseProto propertyResponseProto = Response.PropertyResponseProto.parseFrom(protobufStream);
        return jsonFormat.printToString(propertyResponseProto);
    }

    @Test
    public void getContractById() {
        InputStream responseStream = null;
        String jsonOutput = null;
        try {
            responseStream = executeHttpRequest("http://localhost:8080/contract/5?tenant_id=AC40&property_id=9");
            jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
            System.out.println(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteContractById() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete("http://localhost:8080/contract/2?tenant_id=AC40&property_id=5");
            HttpResponse httpResponse = httpClient.execute(request);
            InputStream responseStream = httpResponse.getEntity().getContent();
            byte[] buff = new byte[responseStream.available()];
            responseStream.read(buff);
            System.out.println(new String(buff));
            responseStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
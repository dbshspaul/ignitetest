package com.jac.travels.ignite.cache.store;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.idclass.RatePlanPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RatePlan;
import com.jac.travels.spring.controller.BeanExporter;
import com.jac.travels.utility.QueryBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.util.ArrayList;
import java.util.List;

public class RatePlanCacheStore extends CacheStoreAdapter<RatePlanPK, RatePlan> {
    Logger logger = LoggerFactory.getLogger(RatePlanCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RatePlan load(RatePlanPK ratePlanPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + ratePlanPK + ']');
        return queryBuilder.getDataById(RatePlan.class, ratePlanPK);
    }

    @Override
    public void write(Cache.Entry<? extends RatePlanPK, ? extends RatePlan> entry) throws CacheWriterException {
        RatePlanPK key = entry.getKey();
        RatePlan rate = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + rate + ']');
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(rate);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost("http://localhost:8080/rate-plans");

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("ratePlan", jsonInString));
            request.setEntity(new UrlEncodedFormEntity(params));
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/x-www-form-urlencoded");

            HttpResponse httpResponse = httpClient.execute(request);
            System.out.println(httpResponse.getEntity().getContent());

//            queryBuilder.insertData(rate);
//            BeanExporter.getInstance().getRatePlanService();
            //ProducerUtil.sendMessage("kafkaCacheTopic", rate.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", rate.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}

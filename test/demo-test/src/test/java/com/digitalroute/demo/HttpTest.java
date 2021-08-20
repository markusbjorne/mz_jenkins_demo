package com.digitalroute.demo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.Before;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.Map;
import java.util.List;
import com.google.gson.Gson; 


/**
 * Unit test for simple App.
 */
public class HttpTest 
{

    static private CloseableHttpClient httpClient = HttpClients.createDefault();

    private static Map response;
    
    private static String doGetRequest(final String url) throws Exception {
        final HttpGet request = new HttpGet(url);
        final CloseableHttpResponse response = httpClient.execute(request);
        final HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity);
        }
        return null;
    }

    public static Map doGet(final String url) throws Exception {
        return new Gson().fromJson(doGetRequest(url), Map.class);
    }

    @Before 
    public void executeRequest() throws Exception {
        response = doGet("http://localhost:9999/usage");
    }

    @Test
    public void serverShouldRespond() throws Exception {
        assertNotNull( response );
    }

    @Test
    public void checkArrayLength() throws Exception {
        List numbers = (List) response.get("numbers");
        assertTrue("Size should be 5", numbers.size() == 5);
    }

    @Test
    public void checkArraySum() throws Exception {
        List numbers = (List) response.get("numbers");
        int sum = 0;
        for (Object number : numbers) sum += (Double)number;
        assertTrue("sum should be 10", sum == 10);

    }

}

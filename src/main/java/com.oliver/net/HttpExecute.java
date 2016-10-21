package com.oliver.net;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;


/**
 * Created by ning on 10/18/16.
 */
public class HttpExecute {

    private static Logger logger= LoggerFactory.getLogger(HttpExecute.class);

    private CloseableHttpClient httpClient;

    public void baseExecute() throws Exception{
        httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse=null;
        HttpGet httpGet=new HttpGet("http://localhost/");
        try{
             httpResponse=httpClient.execute(httpGet);
        }
        catch (Exception e){
            System.out.println(httpResponse.getAllHeaders().length);
        }finally{
            httpResponse.close();
        }
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.google.com")
                .setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "")
                .build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());

    }



}

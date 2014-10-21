package com.crawler.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Logger 
{
    HttpClient client;
    String username;
    String password;
    
    public Logger(String username, String password)
    {
        client = HttpClients.createDefault();
        this.username = username;
        this.password = password;
    }
    
    //login and set cookies
    public void loggin(String urlStr)
    {
        HttpPost post = new HttpPost(urlStr);
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("id", username));
        formParams.add(new BasicNameValuePair("passwd", password));
        formParams.add(new BasicNameValuePair("mode", "0"));
        formParams.add(new BasicNameValuePair("CookieDate", "0"));
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            post.setEntity(entity);
            
            post.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            post.addHeader("Accept-Encoding", "gzip,deflate,sdch");
            post.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
            post.addHeader("Connection", "keep-alive");
            //post.addHeader("Content-Length", Integer.toString(EntityUtils.toString(entity).length()));
            post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            post.addHeader("Cookie", "login-user=" + username);
            post.addHeader("Host", "bbs.byr.cn");
            post.addHeader("Origin", "http://bbs.byr.cn");
            post.addHeader("Referer", "http://bbs.byr.cn/index");
            post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1464.0 Safari/537.36");
            post.addHeader("X-Requested-With", "XMLHttpRequest");


            HttpResponse response = client.execute(post);
            HttpEntity result = response.getEntity();
            String context = EntityUtils.toString(result);
            System.out.println(context);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //get picture list
    public void getPicUrlList(String urlStr)
    {
        HttpGet get = new HttpGet(urlStr + username);
        get.addHeader("Accept", "*/*");
        get.addHeader("Accept-Encoding", "gzip,deflate,sdch");
        get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
        get.addHeader("Connection", "keep-alive");
        get.addHeader("Host", "bbs.byr.cn");
        get.addHeader("Referer", "http://bbs.byr.cn/");
        get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1464.0 Safari/537.36");
        get.addHeader("X-Requested-With", "XMLHttpRequest");
        
        HttpResponse response;
        try {
            response = client.execute(get);
            HttpEntity result = response.getEntity();
            String context = EntityUtils.toString(result);
            System.out.println(context);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

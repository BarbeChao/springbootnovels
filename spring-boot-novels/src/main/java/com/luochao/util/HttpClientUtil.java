package com.luochao.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtil {
    public static void main(String[] args) {
        String re =doGet("https://book.qidian.com/info/1001535146/");
        System.out.println(re);
    }

    //    传入URL，获取返回的String字符串
    public static String doGet(String url){
        //创建一个执行完自动关闭的客户端
        CloseableHttpClient httpClient = null;
        //创建一个执行完会自动关闭的响应流
        CloseableHttpResponse response = null;
        //接收返回数据
        String result = null;

        //创建客户端
        httpClient = HttpClients.createDefault();

        //创建一个读取url的请求
        HttpGet httpGet = new HttpGet(url);
        //定义协议头
        httpGet.setHeader("Accept","application/json");
//        设置http请求所需要的时间        连接超时时间、发送请求超时时间、读取超时时间
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(35000)
                .setConnectionRequestTimeout(35000)
                .setSocketTimeout(60000)
                .build();

        //把配置信息设置到get请求中，如连接池的设计
        httpGet.setConfig(config);
        try {
            //客户端通过创建的请求获取到响应信息组
            response = httpClient.execute(httpGet);
            //获取到里面所有的JSON响应信息
            HttpEntity entity = response.getEntity();
            //把响应信息转为字符串
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流严谨判断
            try {
                if (response !=null){
                    response.close();
                }

                if(httpClient !=null){
                    httpClient.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //响应出来
        return result;
    }
}

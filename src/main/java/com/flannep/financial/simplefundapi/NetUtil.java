package com.flannep.financial.simplefundapi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 网络操作工具
 *
 * @author FlanN
 */
public class NetUtil {

    static OkHttpClient client = new OkHttpClient();

    /**
     * 发送get请求
     *
     * @param url    目标URL
     * @param header 请求头
     * @return
     * @throws Exception 抛出任何异常
     */
    public static String sendGet(String url, Map<String, String> header) throws Exception {
        return new String(getByte(url, header), StandardCharsets.UTF_8);
    }


    /**
     * 发送post请求
     *
     * @param url    目标URL
     * @param header 请求头
     * @param param  附加参数
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, Map<String, String> header, String param) throws Exception {
        //提交空的body
        if (param == null) {
            param = "";
        }

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(RequestBody.create(null, param));

        for (String key : header.keySet()) {
            String value = header.get(key);
            builder.header(key, value);
        }

        Request rq = builder.build();

        try (Response response = client.newCall(rq).execute()) {
            return response.body().string();
        }
    }


    /**
     * 获取二进制文件数据
     *
     * @param url    目标url
     * @param header 请求头
     * @return 目标文件数据
     * @throws Exception
     */
    private static byte[] getByte(String url, Map<String, String> header) throws Exception {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if (header!=null){
            for (String key : header.keySet()) {
                String value = header.get(key);
                builder.header(key, value);
            }
        }
        try (Response response = client.newCall(builder.build()).execute()) {
            return response.body().bytes();
        }
    }


}

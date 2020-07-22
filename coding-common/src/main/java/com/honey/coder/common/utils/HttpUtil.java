package com.honey.coder.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http请求类，支持http和https
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 30000;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(10);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     *
     * @param url 请求地址
     * @return 响应文本
     */
    public static String doGet(String url) {
        return doGet(url, new HashMap<String, Object>());
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     *
     * @param url 请求地址
     * @return 响应文本
     */
    public static String doGet(Integer maxTimeout, String url) {
        return doGet(maxTimeout, url, new HashMap<String, Object>());
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 响应文本
     */
    public static String doGet(String url, Map<String, Object> params) {
        return doGet(null, url, params);
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 响应文本
     */
    public static String doGet(Integer maxTimeout, String url, Map<String, Object> params) {
        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        apiUrl += param;
        logger.info("GET请求：{}", apiUrl);
        String result = null;
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpPost = new HttpGet(apiUrl);
            if (maxTimeout != null && maxTimeout > 0) {
                RequestConfig.Builder configBuilder = RequestConfig.custom();
                configBuilder.setConnectTimeout(maxTimeout);
                configBuilder.setSocketTimeout(maxTimeout);
                configBuilder.setConnectionRequestTimeout(maxTimeout);
                RequestConfig config = configBuilder.build();
                httpPost.setConfig(config);
            } else {
                httpPost.setConfig(requestConfig);
            }
            HttpResponse response = httpclient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     *
     * @param url 请求地址
     * @return 响应流
     */
    public static InputStream doGetStream(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpPost = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream stream = entity.getContent();
                return stream;
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 发送 POST 请求（HTTP），不带输入数据
     *
     * @param url 请求地址
     * @return 响应文本
     */
    public static String doPost(String url) {
        return doPost(url, new HashMap<String, Object>());
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 响应文本
     */
    public static String doPost(String url, Map<String, Object> params) {
        return doPost(url, params, null);
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 响应文本
     */
    public static String doPost(String url, Map<String, Object> params, Map<String, String> heads) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            if (heads != null) {
                for (String key : heads.keySet()) {
                    httpPost.addHeader(key, heads.get(key));
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return 响应文本
     */
    public static String doPost(String url, JSONObject json) {
        return doPost(null, url, json);
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param maxTimeout
     * @param url
     * @return 响应文本
     */
    public static String doPost(Integer maxTimeout, String url) {
        return doPost(maxTimeout, url, null);
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param url        请求地址
     * @param json       请求参数
     * @param maxTimeout 最大超时时间
     * @return
     */
    public static String doPost(Integer maxTimeout, String url, JSONObject json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            if (maxTimeout != null && maxTimeout > 0) {
                RequestConfig.Builder configBuilder = RequestConfig.custom();
                configBuilder.setConnectTimeout(maxTimeout);
                configBuilder.setSocketTimeout(maxTimeout);
                configBuilder.setConnectionRequestTimeout(maxTimeout);
                RequestConfig config = configBuilder.build();
                httpPost.setConfig(config);
            } else {
                httpPost.setConfig(requestConfig);
            }
            StringEntity stringEntity = null;
            if (json != null) {
                stringEntity = new StringEntity(JSON.toJSONString(json, SerializerFeature.DisableCircularReferenceDetect), "UTF-8");//解决中文乱码问题
            } else {
                stringEntity = new StringEntity("");
            }
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return 响应文本
     */
    public static String doPost(String url, JSONObject json, boolean falg) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = null;
            if (json != null) {
                stringEntity = new StringEntity(JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue), "UTF-8");//解决中文乱码问题
            } else {
                stringEntity = new StringEntity("");
            }
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    public static String doPost(String url, JSONObject json, Map<String, String> heads) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            if (heads != null) {
                for (String key : heads.keySet()) {
                    httpPost.addHeader(key, heads.get(key));
                }
            }
            StringEntity stringEntity = null;
            if (json != null) {
                stringEntity = new StringEntity(json.toJSONString(), "UTF-8");//解决中文乱码问题
            } else {
                stringEntity = new StringEntity("");
            }
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return 响应文本
     */
    public static String doPostGetCookie(String url, JSONObject json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = null;
            if (json != null) {
                stringEntity = new StringEntity(json.toJSONString(), "UTF-8");//解决中文乱码问题
            } else {
                stringEntity = new StringEntity("");
            }
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            Header[] headers = response.getHeaders("Set-Cookie");
            if (headers != null && headers.length > 0) {
                return headers[0].getValue().split("; ")[0];
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return "";
    }

    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 响应文本
     */
    public static String doPostSSL(String url, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return 响应文本
     */
    public static String doPostSSL(String url, JSONObject json) {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toJSONString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 创建SSL安全连接
     *
     * @return
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
        } catch (GeneralSecurityException e) {
            logger.error(e.getMessage(), e);
        }
        return sslsf;
    }

}
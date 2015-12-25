package com.cgq.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map; 
import java.util.Map.Entry;


/**
 * <pre>
 * HTTP请求代理类
 * </pre>
 */
public class HttpRequestProxy
{
    /**
     * 连接超时
     */
    private static int connectTimeOut = 5000;

    /**
     * 读取数据超时
     */
    private static int readTimeOut = 10000;

    /**
     * 请求编码
     */
    private static String requestEncoding = "UTF-8";


    /**
     * <pre>
     * 发送带参数的GET的HTTP请求
     * </pre>
     * 
     * @param reqUrl HTTP请求URL
     * @param parameters 参数映射表
     * @return HTTP响应的字符串
     */
    public static String doGet(String reqUrl, Map parameters,
            String recvEncoding)
    {
        HttpURLConnection url_con = null;
        String responseContent = null;
        OutputStream  ops = null;
        InputStream in = null;
        BufferedReader rd = null;
        InputStreamReader isr = null;
        try
        {
            StringBuffer params = new StringBuffer();
            for (Iterator iter = parameters.entrySet().iterator(); iter
                    .hasNext();)
            {
                Entry element = (Entry) iter.next();
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(),
                        HttpRequestProxy.requestEncoding));
                params.append("&");
            }

            if (params.length() > 0)
            {
                params = params.deleteCharAt(params.length() - 1);
            }

            URL url = new URL(reqUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("GET");
            System.setProperty("sun.net.client.defaultConnectTimeout", String
                    .valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
            System.setProperty("sun.net.client.defaultReadTimeout", String
                    .valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
            // url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
            // 1.5换成这个,连接超时
            // url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
            url_con.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            ops = url_con.getOutputStream();
            ops.write(b, 0, b.length);
    		ops.flush();

            in = url_con.getInputStream();
            
            isr = new InputStreamReader(in,  recvEncoding);
            
            rd = new BufferedReader(isr);
            
            String tempLine = rd.readLine();
            StringBuffer temp = new StringBuffer();
            String crlf=System.getProperty("line.separator");
            while (tempLine != null)
            {
                temp.append(tempLine);
                temp.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = temp.toString();
            
        }
        catch (IOException e)
        {
           // logger.error("网络故障", e);
        }
        finally
        {	
        	try{if(rd != null)rd.close();}catch(Exception e){}
        	try{if(isr != null)isr.close();}catch(Exception e){}
        	try{if(in != null)in.close();}catch(Exception e){}
        	try{if(ops != null)ops.close();}catch(Exception e){}
        	
            if (url_con != null)
            {
                url_con.disconnect();
            }
        }

        return responseContent;
    }
    
    
    
    
    
    
    public static String getMethod(String reqUrl, Map parameters,String recvEncoding) throws IOException
    {
        HttpURLConnection url_con = null;
        String responseContent = null;
        OutputStream  ops = null;
        InputStream in = null;
        BufferedReader rd = null;
        InputStreamReader isr = null;
     
            StringBuffer params = new StringBuffer();
            for (Iterator iter = parameters.entrySet().iterator(); iter
                    .hasNext();)
            {
                Entry element = (Entry) iter.next();
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(),HttpRequestProxy.requestEncoding));
                params.append("&");
            }

            if (params.length() > 0)
            {
                params = params.deleteCharAt(params.length() - 1);
            }

            URL url = new URL(reqUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("GET");
            System.setProperty("sun.net.client.defaultConnectTimeout", String
                    .valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
            System.setProperty("sun.net.client.defaultReadTimeout", String
                    .valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
            // url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
            // 1.5换成这个,连接超时
            // url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
            url_con.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            ops = url_con.getOutputStream();
            ops.write(b, 0, b.length);
    		ops.flush();

            in = url_con.getInputStream();
            
            isr = new InputStreamReader(in,  recvEncoding);
            
            rd = new BufferedReader(isr);
            
            String tempLine = rd.readLine();
            StringBuffer temp = new StringBuffer();
            String crlf=System.getProperty("line.separator");
            while (tempLine != null)
            {
                temp.append(tempLine);
                temp.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = temp.toString();
            
     
       
       

        return responseContent;
    }
    
    
    
    
    
    
    

    /**
     * <pre>
     * 发送不带参数的GET的HTTP请求
     * </pre>
     * 
     * @param reqUrl HTTP请求URL
     * @return HTTP响应的字符串
     */
    public static String doGet(String reqUrl, String recvEncoding)
    {
        HttpURLConnection url_con = null;
        String responseContent = null;
        OutputStream  ops = null;
        InputStream in = null;
        BufferedReader rd = null;
        InputStreamReader isr = null;
        try
        {
            StringBuffer params = new StringBuffer();
            String queryUrl = reqUrl;
            int paramIndex = reqUrl.indexOf("?");

            if (paramIndex > 0)
            {
                queryUrl = reqUrl.substring(0, paramIndex);
                String parameters = reqUrl.substring(paramIndex + 1, reqUrl
                        .length());
                String[] paramArray = parameters.split("&");
                for (int i = 0; i < paramArray.length; i++)
                {
                    String string = paramArray[i];
                    int index = string.indexOf("=");
                    if (index > 0)
                    {
                        String parameter = string.substring(0, index);
                        String value = string.substring(index + 1, string
                                .length());
                        params.append(parameter);
                        params.append("=");
                        params.append(URLEncoder.encode(value,
                                HttpRequestProxy.requestEncoding));
                        params.append("&");
                    }
                }

                params = params.deleteCharAt(params.length() - 1);
            }

            URL url = new URL(queryUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("GET");
            System.setProperty("sun.net.client.defaultConnectTimeout", String
                    .valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
            System.setProperty("sun.net.client.defaultReadTimeout", String
                    .valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
            
	
            // url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
            // 1.5换成这个,连接超时
            // url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
            url_con.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            
            ops = url_con.getOutputStream();
            ops.write(b, 0, b.length);
            ops.flush();
            
            in = url_con.getInputStream();
            isr = new InputStreamReader(in,  recvEncoding);
            rd = new BufferedReader(isr);
            String tempLine = rd.readLine();
            StringBuffer temp = new StringBuffer();
            String crlf=System.getProperty("line.separator");
            while (tempLine != null)
            {
                temp.append(tempLine);
                temp.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = temp.toString();
            rd.close();
            in.close();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
            System.out.println("网络故障"+e.toString());
        }
        finally
        {
        	try{if(rd != null)rd.close();}catch(Exception e){}
        	try{if(isr != null)isr.close();}catch(Exception e){}
        	try{if(in != null)in.close();}catch(Exception e){}
        	try{if(ops != null)ops.close();}catch(Exception e){}
            if (url_con != null)
            {
                url_con.disconnect();
            }
        }

        return responseContent;
    }

    /**
     * <pre>
     * 发送带参数的POST的HTTP请求
     * </pre>
     * 
     * @param reqUrl HTTP请求URL
     * @param parameters 参数映射表
     * @return HTTP响应的字符串
     */
    public static String doPost(String reqUrl, Map parameters,
            String recvEncoding)
    {
        HttpURLConnection url_con = null;
        String responseContent = null;
        OutputStream  ops = null;
        InputStream in = null;
        BufferedReader rd = null;
        InputStreamReader isr = null;
        try
        {
            StringBuffer params = new StringBuffer();
            for (Iterator iter = parameters.entrySet().iterator(); iter
                    .hasNext();)
            {
                Entry element = (Entry) iter.next();
                System.out.println(element.getKey()+"=======key - value============="+element.getValue());
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(), HttpRequestProxy.requestEncoding));
                params.append("&");
            }

            if (params.length() > 0)
            {
                params = params.deleteCharAt(params.length() - 1);
            }

            URL url = new URL(reqUrl);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            System.setProperty("sun.net.client.defaultConnectTimeout", String
                    .valueOf(HttpRequestProxy.connectTimeOut));// （单位：毫秒）jdk1.4换成这个,连接超时
            System.setProperty("sun.net.client.defaultReadTimeout", String
                    .valueOf(HttpRequestProxy.readTimeOut)); // （单位：毫秒）jdk1.4换成这个,读操作超时
            // url_con.setConnectTimeout(5000);//（单位：毫秒）jdk
            // 1.5换成这个,连接超时
            // url_con.setReadTimeout(5000);//（单位：毫秒）jdk 1.5换成这个,读操作超时
            url_con.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            ops = url_con.getOutputStream();
            ops.write(b, 0, b.length);
            ops.flush();

            in = url_con.getInputStream();
            isr = new InputStreamReader(in,  recvEncoding);
            rd = new BufferedReader(isr);
            String tempLine = rd.readLine();
            StringBuffer tempStr = new StringBuffer();
            //String crlf=System.getProperty("line.separator");
            while (tempLine != null)
            {
                tempStr.append(tempLine);
                //tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = tempStr.toString();
        }
        catch (IOException e)
        {
            //logger.error("网络故障", e);
        }
        finally
        {
        	try{if(rd != null)rd.close();}catch(Exception e){}
        	try{if(isr != null)isr.close();}catch(Exception e){}
        	try{if(in != null)in.close();}catch(Exception e){}
        	try{if(ops != null)ops.close();}catch(Exception e){}
            if (url_con != null)
            {
                url_con.disconnect();
            }
        }
        return responseContent;
    }

    /**
     * @return 连接超时(毫秒)
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#connectTimeOut
     */
    public static int getConnectTimeOut()
    {
        return HttpRequestProxy.connectTimeOut;
    }

    /**
     * @return 读取数据超时(毫秒)
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#readTimeOut
     */
    public static int getReadTimeOut()
    {
        return HttpRequestProxy.readTimeOut;
    }

    /**
     * @return 请求编码
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#requestEncoding
     */
    public static String getRequestEncoding()
    {
        return requestEncoding;
    }

    /**
     * @param connectTimeOut 连接超时(毫秒)
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#connectTimeOut
     */
    public static void setConnectTimeOut(int connectTimeOut)
    {
        HttpRequestProxy.connectTimeOut = connectTimeOut;
    }

    /**
     * @param readTimeOut 读取数据超时(毫秒)
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#readTimeOut
     */
    public static void setReadTimeOut(int readTimeOut)
    {
        HttpRequestProxy.readTimeOut = readTimeOut;
    }

    /**
     * @param requestEncoding 请求编码
     * @see com.cgq.util.hengpeng.common.web.HttpRequestProxy#requestEncoding
     */
    public static void setRequestEncoding(String requestEncoding)
    {
        HttpRequestProxy.requestEncoding = requestEncoding;
    }
    
    public static void main(String args []){
    	String srg = HttpRequestProxy.doPost("http://www.baidu.com", null,"gbk");  
    	System.out.println(srg);
    }
}
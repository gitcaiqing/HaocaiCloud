package com.haocai.base.cloudbase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.util.URIUtil;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * HTTP请求工具类
 * @param
 * @return
 * @author CQ
 * @date 2020/5/13 13:32
 */
public class HttpConnUtil {
	
	/**
	 * HttpClient GET请求，返回响应字符串，如果请求失败，则返回null
	 * @param url
	 * @param queryString
	 * @param cmtimeout 连接池超时时间
	 * @param sotimeout 获取响应的最长等待时间
	 * @return
	 */
	public static String httpConn(String url, String queryString, long cmtimeout, int sotimeout) {
		return httpConn(url, queryString, cmtimeout, sotimeout, 0);
	}
	
	/**
	 * HttpClient POST请求，返回响应字符串，如果请求失败，则返回null
	 * @param url
	 * @param queryString
	 * @param cmtimeout 连接池超时时间
	 * @param sotimeout 获取响应的最长等待时间
	 * @return
	 */
	public static String httpPostConn(String url, String queryString, long cmtimeout, int sotimeout) {
		return httpConn(url, queryString, cmtimeout, sotimeout, 1);
	}
	
	private static String httpConn(String url, String queryString, long cmtimeout, int sotimeout, int flag){
		//创建链接的相关参数
		HttpClientParams httpConnectionParams;
		HttpClient client;
		HttpMethod method = null;
		String encodeQuery;
		//获取返回的流
		BufferedReader reader = null;
		//返回的字符串
		StringBuilder responseStr = new StringBuilder();
		try {
			httpConnectionParams = new HttpClientParams();
			//设置连接池超时时间，单位毫秒
			httpConnectionParams.setConnectionManagerTimeout(cmtimeout);
			//设置获取响应的最长等待时间，单位毫秒
			if (sotimeout > 0) {
				httpConnectionParams.setSoTimeout(sotimeout);
			}
			client = new HttpClient(httpConnectionParams);
			//请求url和相关参数
			if (flag == 0) {
				method = new GetMethod(url);
			} else {
				method = new PostMethod(url);
			}
			//编码设置
			encodeQuery = URIUtil.encodeQuery(queryString, "UTF-8");
			
			method.setQueryString(encodeQuery);
			//建立请求
			client.executeMethod(method);
			//获取响应
			reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));			
			String line;
			while ((line = reader.readLine()) != null) {
				responseStr.append(line).append(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭字符流
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//释放连接
			if (method != null) {
				method.releaseConnection();
			}
		}
		return responseStr.toString();
	}
	
	/**
	 * URLConnection GET 请求
	 * @param url 请求地址
	 * @param param 请求参数字符串
	 * @param conntimeout 连接主机超时（单位：毫秒）
	 * @param readtimeout 从主机读取数据超时（单位：毫秒）
	 * 2016-07-23 新增：此方法请求后，会自动对URLEncoder编码的数据进行还原。若httpConn方法对接时发生数据验证不通过，可更换此方法尝试。
	 */
	public static String sendGet(String url, String param, int conntimeout, int readtimeout) {
		BufferedReader in = null;
		StringBuilder ret = new StringBuilder();
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			connection.setConnectTimeout(conntimeout);
			connection.setReadTimeout(readtimeout);
			// 设置通用的请求属性
			connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				ret.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return ret.toString();
	}

	/**
	 * URLConnection POST 请求
	 * @param url 请求地址
	 * @param param 请求参数字符串
	 * @param conntimeout 连接主机超时（单位：毫秒）
	 * @param readtimeout 从主机读取数据超时（单位：毫秒）
	 */
	public static String sendPost(String url, Object param, int conntimeout, int readtimeout) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder ret = new StringBuilder();
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			conn.setConnectTimeout(conntimeout);
			conn.setReadTimeout(readtimeout);
			// 设置通用的请求属性
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			
			String line;
			while ((line = in.readLine()) != null) {
				ret.append(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return ret.toString();
	}

}

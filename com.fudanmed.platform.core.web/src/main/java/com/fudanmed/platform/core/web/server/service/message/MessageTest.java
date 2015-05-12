package com.fudanmed.platform.core.web.server.service.message;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedParser;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.util.Key;

public class MessageTest {

	public static class MessageResult {
		@Key
		public String num;
		@Key
		public String success;
		@Key
		public String errid;
	}

	static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	/**
	 * @param args
	 */
	public static void sendMessage() {
		try {
			HttpRequestFactory requestFactory = HTTP_TRANSPORT
					.createRequestFactory(new HttpRequestInitializer() {
						@Override
						public void initialize(HttpRequest request) {
							request.setParser(new UrlEncodedParser());
						}
					});
			byte[] b = "你好".getBytes("UTF-8"); //中间用ISO-8859-1过渡
			String name = new String(b, "UTF-16"); //转换成GB2312字符	
			HttpRequest request = requestFactory
					.buildGetRequest(new GenericUrl(
							"http://121.52.221.108/send/gsend.aspx?name=fdhq&pwd=fdhq888&dst=13818095599&msg="+name+"&sequeid=12346"));
			MessageResult result = request.execute().parseAs(
					MessageResult.class);
			System.out.println(result.errid);
			System.out.println(result.success);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

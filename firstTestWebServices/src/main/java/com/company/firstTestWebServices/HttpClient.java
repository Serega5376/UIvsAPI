package com.company.firstTestWebServices;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class HttpClient {

	private static CloseableHttpClient httpClient;

	static {
		try {
			httpClient = HttpClients.custom().setSSLContext(SSLContextBuilder.create().loadTrustMaterial(new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) {
					return true;
				}
			}).build()).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		} catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
			throw new RuntimeException(e);
		}
	}

	public String executeGet(String url) throws IOException {

		HttpEntity responseBody = null;
		HttpGet rq = new HttpGet(url);
		try {
			final CloseableHttpResponse response = httpClient.execute(rq);
			responseBody = response.getEntity();
			return EntityUtils.toString(responseBody);
		} finally {
			if (null != responseBody) {
				EntityUtils.consume(responseBody);
			}
		}

	}
}

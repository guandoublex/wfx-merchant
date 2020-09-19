package com.gxx.wfx.merchant;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = "com.gxx.wfx.merchant.dao")
public class WfxMerchantApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfxMerchantApplication.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}

	@Bean
	public RestHighLevelClient restHighLevelClient(){
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("39.99.143.143", 9200, "http")));
		return client;
	}
}

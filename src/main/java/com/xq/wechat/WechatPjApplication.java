package com.xq.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WechatPjApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatPjApplication.class, args);
	}
}

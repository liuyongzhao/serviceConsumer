package com.lyz.cloud.client.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class HelloController {
	    @Autowired
	    private HelloService helloServcie;
	    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	    @RequestMapping("/test/{fallback}")
	    public String hello(@PathVariable("fallback") String fallback){
	        String res=helloServcie.hello(fallback);
	        logger.info("日志1：消费者浏览器发出请求");
	        return "调用服务结果为"+res;
	    }
}

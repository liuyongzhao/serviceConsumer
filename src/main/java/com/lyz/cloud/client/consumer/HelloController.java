package com.lyz.cloud.client.consumer;

import org.apache.log4j.Logger;
/*import org.slf4j.Logger;*/
/*import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class HelloController {
	 	private static Logger logger = Logger.getLogger(HelloController.class);
	    @Autowired
	    private DiscoveryClient consumer;
	    @Autowired
	    private HelloService helloServcie;
	    @RequestMapping("/test/{fallback}")
	    public String hello(@PathVariable("fallback") String fallback){
	        String res=helloServcie.hello(fallback);
	        ServiceInstance instance = consumer.getLocalServiceInstance();
	        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + res + " 日志1************");
	        return "调用服务结果为"+res;
	    }
}

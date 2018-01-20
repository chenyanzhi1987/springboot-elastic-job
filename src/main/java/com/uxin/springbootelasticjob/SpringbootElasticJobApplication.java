package com.uxin.springbootelasticjob;

import com.uxin.springbootelasticjob.config.EmbedZookeeperServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = { "classpath:applicationContext-elastic-job.xml" })
public class SpringbootElasticJobApplication {

	private static final int EMBED_ZOOKEEPER_PORT = 6181;

	public static void main(String[] args) {

		EmbedZookeeperServer.start(EMBED_ZOOKEEPER_PORT); // 启动内嵌zookeeper
		SpringApplication.run(SpringbootElasticJobApplication.class, args);
	}
}

package com.uxin.springbootelasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.apache.log4j.Logger;

/**
 * @program: springboot-elastic-job
 * @description: 本地作业监听器, 执行前后发送消息进行通知
 * 本地监听器只在节点执行自己分片的时候调度，每个分片任务调度的时候本地监听器都会执行。本地监听器由ElasticJobListener接口定义
 * @author: DI CHENG
 * @create: 2018-01-20 13:17
 **/
public class MyElasticJobListener implements ElasticJobListener {

    private static final Logger logger = Logger.getLogger(MyElasticJobListener.class);

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        logger.info(String.format("开始调度任务[%s]", shardingContexts.getJobName()));
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        logger.info(String.format("任务[%s]调度完成", shardingContexts.getJobName()));
    }
}

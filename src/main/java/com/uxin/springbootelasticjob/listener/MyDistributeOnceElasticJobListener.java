package com.uxin.springbootelasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.apache.log4j.Logger;

/**
 * @program: springboot-elastic-job
 * @description: MyDistributeOnceElasticJobListener
 * 本地监听器在作业执行本地的分片任务时会执行，
 * 如上面的示例，我们的作业被分成了6片，则监听器任务会执行6次。
 * 而分布式监听器会在总的任务开始执行时执行一次，在总的任务结束执行时执行一次。
 * 分布式监听器也是在普通监听器的基础上实现的，由AbstractDistributeOnceElasticJobListener抽象类封装的，
 * 其实现了ElasticJobListener接口。
 * 要实现自己的监听器只需要继承AbstractDistributeOnceElasticJobListener抽象类，实现其中的抽象方法即可。
 *
 * 分布式监听器用到了锁的等待和通知，
 * startedTimeoutMilliseconds和completedTimeoutMilliseconds分别用来指定作业开始前和完成后的对应的锁等待最大超时时间。
 * 分布式监听器由<job:distributed-listener/>
 * @author: DI CHENG
 * @create: 2018-01-20 13:27
 **/
public class MyDistributeOnceElasticJobListener extends AbstractDistributeOnceElasticJobListener{

    private static final Logger logger = Logger.getLogger(MyDistributeOnceElasticJobListener.class);

    /**
     * @param startedTimeoutMilliseconds
     * @param completedTimeoutMilliseconds
     */
    public MyDistributeOnceElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        logger.info("分布式监听器开始……");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        logger.info("分布式监听器结束……");
    }
}

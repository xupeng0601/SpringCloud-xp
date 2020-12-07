package org.xupeng.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xupeng
 * @date 2020/12/7 10:46
 * @description
 */
@RestController
public class Controller {



    private static final String KEY = "querySentinel";



    @GetMapping("get")
    @SentinelResource("get")
    public String get() {
        return "OPS正常，没有限流";
    }



    /**
     * 初始化限流配置
     */
    @PostConstruct
    public void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource(KEY);
        // QPS控制在2以内
        rule.setCount(2);
        // QPS限流
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


    /**
     * 初始化熔断控制
     */
    @PostConstruct
    public void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource(KEY);
        // 80s内调用接口出现异常次数超过5的时候, 进行熔断
        rule.setCount(5);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule.setTimeWindow(80);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }



    /**
     *  模拟使用Sentinel注解实现限流
     *
     * @param id
     * @return
     */
    @SentinelResource(value = "querySentinel", blockHandler = "handleFlowQpsException",
            fallback = "queryFallback")
    @GetMapping("/query")
    public String query(String id) {

        // 模拟接口运行时抛出代码异常
        if ("000".equals(id)) {
            throw new RuntimeException();
        }
        return "return info :" + id;
    }

    /**
     * 抛出限流或降级时的处理逻辑
     *
     * 注意: 方法参数、返回值要与原函数保持一致
     * @return
     */
    public String handleFlowQpsException(String id, BlockException e) {
        e.printStackTrace();
        return "handleFlowQpsException for 限流或降级的处理逻辑: " + id;
    }

    /**
     * 订单查询接口运行时抛出的异常提供fallback处理
     *
     * 注意: 方法参数、返回值要与原函数保持一致
     * @return
     */
    public String queryFallback(String id, Throwable e) {
        return "fallback query 接口异常的应急处理: " + id;
    }
}


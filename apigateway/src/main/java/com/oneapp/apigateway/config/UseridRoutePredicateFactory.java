package com.oneapp.apigateway.config;

import com.alibaba.nacos.common.utils.StringUtils;
import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UseridRoutePredicateFactory
        extends AbstractRoutePredicateFactory<MConfig> {
    public UseridRoutePredicateFactory() {
        super(MConfig.class);
    }
    //用于从配置文件中获取参数值赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
        //这里的顺序要跟配置文件中的参数顺序一致
        return Arrays.asList("minId", "maxId");
    }
    // 断言
    @Override
    public Predicate<ServerWebExchange> apply(MConfig config) {
        return serverWebExchange -> {
            String idStr = serverWebExchange.getRequest()
                    .getQueryParams().getFirst("userid");
            if (StringUtils.isNotEmpty(idStr)) {
                int id = Integer.parseInt(idStr);
                return id >= config.getMinId() && id <= config.getMaxId();
            }
            return true;
        };
    }
}

@Data // 如果报错需要导入lombok依赖
class MConfig {
    private int minId;
    private int maxId;
}

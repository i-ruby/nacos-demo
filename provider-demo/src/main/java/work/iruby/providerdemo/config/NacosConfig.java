package work.iruby.providerdemo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author 宋扬
 * @since 2021/7/19
 */
@Getter
@Component
@RefreshScope
public class NacosConfig {

    @Value("${user.name:zz}")
    String userName;

    @Value("${user.age:25}")
    Integer age;
}

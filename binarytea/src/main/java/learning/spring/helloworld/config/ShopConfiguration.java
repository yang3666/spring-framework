package learning.spring.helloworld.config;

import learning.spring.helloworld.binarytea.BinaryTeaProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BinaryTeaProperties.class)
@ConditionalOnProperty(name = "binarytea.ready",havingValue = "true")
public class ShopConfiguration {
}

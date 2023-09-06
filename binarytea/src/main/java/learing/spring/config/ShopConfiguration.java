package learing.spring.config;

import learing.spring.binarytea.BinaryTeaProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BinaryTeaProperties.class)
@ConditionalOnProperty(name = "binarytea.ready",havingValue = "true")
public class ShopConfiguration {
}

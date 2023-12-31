package learning.spring.helloworld;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ActuatorSecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     * 需要认证才可访问端点的配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(EndpointRequest.toAnyEndpoint().excluding("health")).
                authorizeRequests((requests)->requests.anyRequest().authenticated());
        http.httpBasic();
    }

    /**
     * 可匿名访问端点的配置
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeRequests((requests) -> requests.anyRequest().anonymous());
//        http.httpBasic();
//    }
}

package demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebConfig {
   public void  HttpConfigurerAdapter(HttpSecurity http) throws Exception;
}

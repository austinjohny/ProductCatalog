package com.austin.productcatalog.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
In configuration class, we tell spring to create some library objects (or Beans) and keep it
/manage its life cycle.
 */

@Configuration
public class RestTemplateConfig {

    // Name of function is immaterial, but the return type is important.
    // Spring will create a bean of type RestTemplate and keep it in its context.
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}

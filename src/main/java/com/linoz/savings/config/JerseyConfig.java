package com.linoz.savings.config;

import com.linoz.savings.api.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by linoz on 2/12/21
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(UserResource.class);
    }
}

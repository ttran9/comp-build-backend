package tran.compbuildbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static tran.compbuildbackend.constants.mapping.MappingConstants.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(FRONT_END_APP_URL)
                .allowedMethods(String.valueOf(HttpMethod.PATCH), String.valueOf(HttpMethod.DELETE),
                        String.valueOf(HttpMethod.POST), String.valueOf(HttpMethod.GET));
    }
}

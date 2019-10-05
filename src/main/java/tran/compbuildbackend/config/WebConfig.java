package tran.compbuildbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static tran.compbuildbackend.constants.mapping.MappingConstants.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins(FRONT_END_MAPPING);
        registry.addMapping("/api/**").allowedOrigins("https://todd-comp-build-frontend.herokuapp.com");
    }
}

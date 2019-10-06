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
        registry.addMapping("/api/**").allowedOrigins(FRONT_END_APP_URL);
        registry.addMapping("/api/computerpart/").allowedOrigins(FRONT_END_APP_URL);
        registry.addMapping("/api/buildnote/").allowedOrigins(FRONT_END_APP_URL);
        registry.addMapping("/api/overclockingnote/").allowedOrigins(FRONT_END_APP_URL);
        registry.addMapping("/api/direction/").allowedOrigins(FRONT_END_APP_URL);
        registry.addMapping("/api/purpose/").allowedOrigins(FRONT_END_APP_URL);
    }
}

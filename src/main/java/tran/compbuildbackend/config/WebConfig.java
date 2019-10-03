package tran.compbuildbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static tran.compbuildbackend.constants.mapping.MappingConstants.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping("/api/**").allowedOrigins("*");
//        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000");
//        registry.addMapping("/api/**").allowedOrigins("http://localhost:3000/");
//        registry.addMapping(BUILD_NOTE_API).allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping(USERS_API).allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping(COMPUTER_PART_API).allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping(DIRECTION_API).allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping(OVERCLOCKING_NOTE_API).allowedOrigins(FRONT_END_MAPPING);
//        registry.addMapping(PURPOSE_API).allowedOrigins(FRONT_END_MAPPING);
    }
}

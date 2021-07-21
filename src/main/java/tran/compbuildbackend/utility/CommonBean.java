package tran.compbuildbackend.utility;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/*
 * TODO: Rename to a better and/or put this into a different sub package for different type of beans used for different
 *  purposes such as email, bean configuration for wiring up dependencies, etc.
 */
@Component
public class CommonBean {
    @Bean
    public BCryptPasswordEncoder passwordEncryptor() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

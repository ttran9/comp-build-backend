package tran.compbuildbackend.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tran.compbuildbackend.constants.tests.TestUtility;

import javax.sql.DataSource;

@Profile(TestUtility.DEVELOPMENT_PROFILE)
@Configuration
public class DevConfig extends AbstractDBConfig {
    @Bean
    public DataSource getDataSource() {
        return super.getMySQLDataSource();
    }
}
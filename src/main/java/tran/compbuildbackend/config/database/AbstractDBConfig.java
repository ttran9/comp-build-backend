package tran.compbuildbackend.config.database;

import org.json.simple.JSONObject;
import org.springframework.boot.jdbc.DataSourceBuilder;
import tran.compbuildbackend.config.config.ConfigReader;
import javax.sql.DataSource;

import static tran.compbuildbackend.constants.config.ConfigurationConstants.CONFIGURATION_FILE_LOCATION;

public class AbstractDBConfig {

    public DataSource getMySQLDataSource() {
        // TODO: check for errors when grabbing the credentials.
        ConfigReader reader = new ConfigReader();
        JSONObject jsonObject = reader.getBackendConfigurationContent(CONFIGURATION_FILE_LOCATION);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName((String) jsonObject.get("CB_MYSQL_DB_DRIVER_CLASS_NAME"));
        dataSourceBuilder.url((String) jsonObject.get("CB_MYSQL_DB_URL"));
        dataSourceBuilder.username((String) jsonObject.get("CB_MYSQL_DB_USER_NAME"));
        dataSourceBuilder.password((String) jsonObject.get("CB_MYSQL_DB_PASSWORD"));
        return dataSourceBuilder.build();
    }

    public DataSource getPostgresDataSource() {
        // TODO: check for errors when grabbing the credentials.
        ConfigReader reader = new ConfigReader();
        JSONObject jsonObject = reader.getBackendConfigurationContent(CONFIGURATION_FILE_LOCATION);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName((String) jsonObject.get("CB_POSTGRES_DB_DRIVER_CLASS_NAME"));
        dataSourceBuilder.url((String) jsonObject.get("CB_POSTGRES_DB_URL"));
        dataSourceBuilder.username((String) jsonObject.get("CB_POSTGRES_DB_USER_NAME"));
        dataSourceBuilder.password((String) jsonObject.get("CB_POSTGRES_DB_PASSWORD"));
        return dataSourceBuilder.build();
    }
}

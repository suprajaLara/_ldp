package springSecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc //provides similar support to <mvc:annotation-driven>
@ComponentScan(basePackages = "springSecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
    // set up variable to hold the properties
    @Autowired
    //select "import org.springframework.core.env.Environment"
    private Environment environment;

    //setup logger for diagnostics
    //select "import java.util.logging.Logger"
    private Logger logger = Logger.getLogger(getClass().getName());

    //define bean for viewResolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //define a bean for security datasource
    @Bean
    //select "import javax.sql.DataSource"
    public DataSource securityDataSource(){
        //create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        //set the jdbc driver class
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exception) {
            throw new RuntimeException(exception);
        }

        //log the connection properties
        logger.info(">>>> jdbc.url="+environment.getProperty("jdbc.url"));
        logger.info(">>>> jdbc.user="+environment.getProperty("jdbc.user"));

        //set db connection props
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        //set connection pool props
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    // need a helper method to handle conversion
    //read environment property and convert to int
    private int getIntProperty(String propName){
        String propValue=environment.getProperty(propName);
        int intPropValue = Integer.parseInt(propValue);
        return intPropValue;
    }

}

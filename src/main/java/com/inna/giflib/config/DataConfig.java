package com.inna.giflib.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setConfigLocation(config);
        sessionFactoryBean.setPackagesToScan(env.getProperty("giflib.entity.package"));
        sessionFactoryBean.setDataSource(dataSourse());
        return sessionFactoryBean;
    }

    @Bean
    public DataSource dataSourse() {
        BasicDataSource ds = new BasicDataSource();

        //driver class name
        ds.setDriverClassName(env.getProperty("giflib.db.driver"));

        //set url
        ds.setUrl(env.getProperty("giflib.db.url"));

        //set username
        ds.setUsername(env.getProperty("giflib.db.username"));

        //set pwd
        ds.setPassword(env.getProperty("giflib.db.password"));

        return ds;
    }
}

package com.sgcib.lafabryik.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * Created by vkonatha061917 on 5/10/2018.
 */
@Configuration
public class HibernateConfig {

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
        factory.setEntityManagerFactory(emf);
        return factory;
    }
}

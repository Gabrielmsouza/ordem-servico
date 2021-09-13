package com.gabriel.ordemservico.config;

import com.gabriel.ordemservico.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    DBService service;

    @Bean
    public void iniciaDB(){
        service.iniciaDb();
    }
}

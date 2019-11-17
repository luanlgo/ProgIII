/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.produtos.apirest.config;

import com.produtos.apirest.models.Obra;
import com.produtos.apirest.repository.ObraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.tools.jar.CommandLine;

/**
 *
 * @author Lucas
 */
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ObraRepository repository) {
     //   repository.deleteAll();
        
        return args -> {
            System.out.println("Preloading " + repository.save(new Obra("lucas","lucas")));
            System.out.println("Preloading " + repository.save(new Obra("lucas","lucas")));
            System.out.println("Preloading " + repository.save(new Obra("lucas","lucas")));
            System.out.println("Preloading " + repository.save(new Obra("lucas","lucas")));
            System.out.println("Preloading " + repository.save(new Obra("lucas","lucas")));
        };
    }

}

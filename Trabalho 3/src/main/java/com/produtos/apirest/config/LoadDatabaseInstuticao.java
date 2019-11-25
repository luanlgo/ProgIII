/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.produtos.apirest.config;

import com.produtos.apirest.models.Instituicao;
import com.produtos.apirest.models.Obra;
import com.produtos.apirest.repository.InstituicaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Lucas
 */
@Configuration
public class LoadDatabaseInstuticao {

    @Bean
    CommandLineRunner initDatabase(InstituicaoRepository repository) {
        //   repository.deleteAll();

        return args -> {
            System.out.println("Preloading " + repository.save(new Instituicao("teste", "Teste")));
            System.out.println("Preloading " + repository.save(new Instituicao("lucas", "lucas")));
            System.out.println("Preloading " + repository.save(new Instituicao("lucas", "lucas")));
            System.out.println("Preloading " + repository.save(new Instituicao("lucas", "lucas")));
            System.out.println("Preloading " + repository.save(new Instituicao("lucas", "lucas")));
            System.out.println("Preloading " + repository.save(new Instituicao("lucas", "lucas")));
        };
    }

}

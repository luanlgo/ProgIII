package com.produtos.apirest.repository;

import com.produtos.apirest.models.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
    
    Instituicao findById(long id);
    
    Instituicao deleteById(long id);

}

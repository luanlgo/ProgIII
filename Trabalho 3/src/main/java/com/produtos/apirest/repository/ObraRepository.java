package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    
    Obra findById(long id);
    
    Obra deleteById(long id);
}

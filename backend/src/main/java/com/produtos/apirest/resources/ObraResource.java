package com.produtos.apirest.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Obra;

import io.swagger.annotations.Api;
import com.produtos.apirest.repository.ObraRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(value="/obras")
@Api(value="API REST Obras")
public class ObraResource {
	
    @Autowired
    private ObraRepository obraRepository;
	 
    @GetMapping
    public List<Obra> getObras() {
        return obraRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Obra getObra(@PathVariable("id") final long id) {
        return obraRepository.findById(id);
    }
    
    @PostMapping
    public Obra insertObra(final Obra obra) {
        return obraRepository.save(obra);
    }
    
    @PutMapping("/{id}")
    public Obra updateObra(@PathVariable("id") final long id, final Obra obra) {
        final Obra obraToPersist = obraRepository.findById(id);
        // ARRUMAR
        return obraRepository.save(obraToPersist);
    }
    
    @DeleteMapping
    
}

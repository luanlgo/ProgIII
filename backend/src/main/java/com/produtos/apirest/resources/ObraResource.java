package com.produtos.apirest.resources;

import com.produtos.apirest.config.DefaultResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Obra;

import io.swagger.annotations.Api;
import com.produtos.apirest.repository.ObraRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(value = "/obras")
@Api(value = "API REST Obras")
public class ObraResource {

    @Autowired
    private ObraRepository obraRepository;

    @ApiOperation(value = "Returns a list of all the books.")
    @GetMapping(produces = "application/json")
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

    @PutMapping
    public Obra updateObra(@RequestBody Obra obra) {
        final Obra obraToPersist = obraRepository.findById(obra.getId());

        if (obraToPersist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não existe!");
        }
        // 
        return obraRepository.save(obra);
    }

    @DeleteMapping("/{id}")
    public DefaultResponse deleteObra(@PathVariable("id") final long id) {
        Obra deleteById = obraRepository.deleteById(id);

        if (deleteById != null) {
            return new DefaultResponse("Atenção! Obra não foi deletada");

        }
        return new DefaultResponse("Atenção! Obra foi deletada");

    }

}

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

    @ApiOperation(value = "Retorna uma lista de Obras.")
    @GetMapping(produces = "application/json")
    public List<Obra> getObras() {
        return obraRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma única obra.")
    public Obra getObra(@PathVariable("id") final long id) {
        return obraRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Insere uma obra")
    public Obra insertObra(final Obra obra) {
        return obraRepository.save(obra);

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma obra")
    public Obra updateObra(@RequestBody Obra obra, @PathVariable long id) {
        final Obra obraToPersist = obraRepository.findById(obra.getId());

        if (obraToPersist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não existe!");
        }
        // 
        return obraRepository.save(obra);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma obra")
    public DefaultResponse deleteObra(@PathVariable("id") final long id) {
        try {
            Obra deleteById = obraRepository.deleteById(id);

        } catch (Exception ex) {
            return new DefaultResponse("Atenção! Obra não foi deletada");
        }
        return new DefaultResponse("Obra foi deletada");
    }
}

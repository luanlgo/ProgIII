package com.produtos.apirest.resources;

import com.produtos.apirest.config.DefaultResponse;
import com.produtos.apirest.models.Instituicao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.InstituicaoRepository;

import io.swagger.annotations.Api;
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
@RequestMapping(value = "/instituicao")
@Api(value = "API REST Instituicao")
public class InstituicaoResource {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Retorna uma lista de Instituições")
    public List<Instituicao> geInstituicaos() {
        return instituicaoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma única Instituição")
    public Instituicao getInstituicao(@PathVariable("id") final long id) {
        return instituicaoRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Salva uma instituição")
    public Instituicao insertInstituicao(final Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);

    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma instituição")
    public Instituicao updateInstituicao(@RequestBody Instituicao instituicao) {
        final Instituicao instituicaoToPersist = instituicaoRepository.findById(instituicao.getId());

        if (instituicaoToPersist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instituição não encontrada!");
        }

        return instituicaoRepository.save(instituicao);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma instituição")
    public DefaultResponse deleteInstituicao(@PathVariable("id") final long id) {
        try {
            Instituicao deleteById = instituicaoRepository.deleteById(id);

        } catch (Exception ex) {
            return new DefaultResponse("Atenção! Instituição não foi deletada");
        }
        return new DefaultResponse("Instituição foi deletada");

    }
}

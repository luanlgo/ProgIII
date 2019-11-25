package com.produtos.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSTITUICAO")
public class Instituicao implements Serializable {

 //   private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String entidade;

    public Instituicao() {
    }

    public Instituicao(String nome, String entidade) {
        this.nome = nome;
        this.entidade = entidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido!");

        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null
                || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da instituição inválido!");
        }
        this.nome = nome;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        if (entidade == null
                || entidade.isEmpty()) {
            throw new IllegalArgumentException("Nome da entidade inválido!");
        }
        this.entidade = entidade;
    }

}

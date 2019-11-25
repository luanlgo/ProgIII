package com.produtos.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_OBRA")
public class Obra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String autor;
    private String titulo;
    private int ano;
    private int edicao;
    private String local;
    private String editora;
    private int paginas;
    private String isbn;
    private String issn;

    public Obra() {
    }

    public Obra(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public Obra(String autor, String titulo, int ano, int edicao, String local, String editora, int paginas, String isbn, String issn) {
        this(autor, titulo);
        this.ano = ano;
        this.edicao = edicao;
        this.local = local;
        this.editora = editora;
        this.paginas = paginas;
        this.isbn = isbn;
        this.issn = issn;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null
                || autor.isEmpty()) {
            throw new IllegalArgumentException("Nome do autor inválido!");
        }
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null
                || titulo.isEmpty()) {
            throw new IllegalArgumentException("Nome do título inválido!");
        }
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException("Ano fornecido é inválido!");
        }
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        if (edicao <= 0) {
            throw new IllegalArgumentException("O número de edição é inválida!");
        }
        this.edicao = edicao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        if (local == null
                || local.isEmpty()) {
            throw new IllegalArgumentException("local inválido!");
        }
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        if (editora == null
                || editora.isEmpty()) {
            throw new IllegalArgumentException("Nome da editora é inválido!");
        }
        this.editora = editora;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        if (paginas <= 0) {
            throw new IllegalArgumentException("O número de páginas fornecido é inválidp!");
        }
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

}

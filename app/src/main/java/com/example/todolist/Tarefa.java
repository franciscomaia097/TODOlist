package com.example.todolist;

public class Tarefa {
    private String idTarefa;
    private String titulo;
    private String descricao;
    private String data;
    private int status;


public Tarefa() {

}

public Tarefa (String titulo, String descricao, String data, int status) {
    this.idTarefa = idTarefa;
    this.titulo = titulo;
    this.descricao = descricao;
    this.data = data;
    this.status = status;
}

    public String getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(String idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

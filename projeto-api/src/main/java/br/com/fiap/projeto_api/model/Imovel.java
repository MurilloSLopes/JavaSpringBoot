package br.com.fiap.projeto_api.model;

public class Imovel {
    public int codigo;
    public String descriacao;
    public double dimensao;
    public double valor;

    public Imovel() {

    }

    public Imovel(String descriacao, double dimensao, double valor) {
        this.descriacao = descriacao;
        this.dimensao = dimensao;
        this.valor = valor;
    }

    public Imovel(int codigo, String descriacao, double dimensao, double valor) {
        this.codigo = codigo;
        this.descriacao = descriacao;
        this.dimensao = dimensao;
        this.valor = valor;
    }

    public int getId() {
        return codigo;
    }

    public void setId(int codigo) {
        this.codigo = codigo;
    }

    public String getDescriacao() {
        return descriacao;
    }

    public void setDescriacao(String descriacao) {
        this.descriacao = descriacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

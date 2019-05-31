package Objects;

import java.util.Date;

public class Produto {
    private int id;

    private String fornecedor;
    private String descricao;
    private Date dataDeCriacao;
    private double precoUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedor = fornecedorId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Produto(int id, String fornecedor, String descricao, Date dataDeCriacao, double precoUnitario){
        this.id = id;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.dataDeCriacao = dataDeCriacao;
        this.precoUnitario = precoUnitario;
    }
    @Override
    public String toString(){
        return this.getDescricao();
    }




}

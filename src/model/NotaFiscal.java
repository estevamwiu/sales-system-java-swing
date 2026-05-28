package model;

import java.util.Date;

public class NotaFiscal {

    private int id_nf;
    private Date dataEmissao;
    private int idCliente;
    private int idProduto;
    private int quantidade;
    private double valor;

    public NotaFiscal() {
        this.id_nf = id_nf;
        this.dataEmissao = dataEmissao;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getIdNF() {
        return id_nf;
    }

    public void setIdNF(int id_nf) {
        this.id_nf = id_nf;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdProduto(){
        return idProduto;
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
}
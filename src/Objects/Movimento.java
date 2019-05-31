package Objects;

public class Movimento {

    private int id;
    private int produtoId;
    private int operacaoId;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getOperacaoId() {
        return operacaoId;
    }

    public void setOperacaoId(int operacaoId) {
        this.operacaoId = operacaoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Movimento(int id, int produtoId, int operacaoId, int quantidade){
        this.id = id;
        this.produtoId = produtoId;
        this.operacaoId = operacaoId;
        this.quantidade = quantidade;
    }
}

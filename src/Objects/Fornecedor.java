package Objects;

public class Fornecedor {

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor(int id, String descricao){

        this.id= id;
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return this.getDescricao();
    }

}


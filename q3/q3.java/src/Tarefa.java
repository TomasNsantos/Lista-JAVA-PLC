public class Tarefa<T> {
    private String descricao;
    private T responsavel;

    public Tarefa(String descricao, T responsavel) {
        this.descricao = descricao;
        this.responsavel = responsavel;
    }

    public String getDescricaoTarefa(){
        return this.descricao;
    }

    public T getResponsavelTarefa() {
        return responsavel;
    }
}
 
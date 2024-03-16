abstract class ProdutoEletronico {
    protected String modelo;
    protected int anoLancamento;
    protected double preco;
    protected String sistemaOperacional;
    protected int quantidadeDisponivel;

    public ProdutoEletronico(String modelo, int anoLancamento, double preco, String sistemaOperacional, int quantidadeDisponivel) {
        this.modelo = modelo;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
        this.sistemaOperacional = sistemaOperacional;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public abstract void exibirInformacoes();
}

class Smartphone extends ProdutoEletronico {
    public Smartphone(String modelo, int anoLancamento, double preco, String sistemaOperacional, int quantidadeDisponivel) {
        super(modelo, anoLancamento, preco, sistemaOperacional, quantidadeDisponivel);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Smartphone: " + modelo);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Preço: " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional);
        System.out.println("Quantidade Disponível: " + quantidadeDisponivel);
        System.out.println("--------------------------");
    }
}

class Tablet extends ProdutoEletronico {
    public Tablet(String modelo, int anoLancamento, double preco, String sistemaOperacional, int quantidadeDisponivel) {
        super(modelo, anoLancamento, preco, sistemaOperacional, quantidadeDisponivel);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Tablet: " + modelo);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Preço: " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional);
        System.out.println("Quantidade Disponível: " + quantidadeDisponivel);
        System.out.println("--------------------------");
    }
}

class Notebook extends ProdutoEletronico {
    private boolean isTouchScreen;

    public Notebook(String modelo, int anoLancamento, double preco, String sistemaOperacional, int quantidadeDisponivel, boolean isTouchScreen) {
        super(modelo, anoLancamento, preco, sistemaOperacional, quantidadeDisponivel);
        this.isTouchScreen = isTouchScreen;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Notebook: " + modelo);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Preço: " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional);
        System.out.println("Quantidade Disponível: " + quantidadeDisponivel);
        System.out.println("Touch Screen: " + (isTouchScreen ? "Sim" : "Não"));
        System.out.println("--------------------------");
    }
}

class Loja {
    public void venderProduto(ProdutoEletronico produtoEletronico) {
        if (produtoEletronico.quantidadeDisponivel > 0) {
            System.out.println("Produto vendido:");
            produtoEletronico.exibirInformacoes();
            produtoEletronico.quantidadeDisponivel--;
        } 
        else {
            System.out.println("Não há mais estoque de " + produtoEletronico.modelo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        Smartphone smartphone = new Smartphone("Galaxy S21", 2021, 2999.99, "Android", 3);
        Tablet tablet = new Tablet("iPad Pro", 2020, 1299.99, "iOS", 2);
        Notebook notebook = new Notebook("Dell XPS 13", 2022, 1799.99, "Windows", 1, true);
        Notebook notebook2 = new Notebook("Avell A72", 2024, 11999.99, "Windows", 0, false);

        loja.venderProduto(smartphone);
        loja.venderProduto(tablet);
        loja.venderProduto(notebook);
        loja.venderProduto(notebook2);
    }
}
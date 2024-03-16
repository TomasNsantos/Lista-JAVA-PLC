// Classe CartaoCredito
public class CartaoCredito implements FormaDePagamento {
    private String senha;
    private String codigoSeguranca;

    public CartaoCredito(String senha, String codigoSeguranca) {
        this.senha = senha;
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public boolean autenticar() {
        return senha.equals("12345") && codigoSeguranca.equals("678");
    }

    @Override
    public void processarPagamento(double valor) throws AutenticacaoException {
        if (autenticar()) {
            System.out.println("Pagamento com cartão de crédito no valor de " + valor + " processado com sucesso");
        } 
        else {
            throw new AutenticacaoException("Autenticacao falhou para pagar " + valor + " com cartao de credito");
        }
    }
}
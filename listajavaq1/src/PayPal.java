// Classe PayPal
public class PayPal implements FormaDePagamento {
    private String login;
    private String senha;

    public PayPal(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public boolean autenticar() {
        boolean c = login.equals("pnc") && senha.equals("senha123");
        return c;
    }

    @Override
    public void processarPagamento(double valor) throws AutenticacaoException {
        if (autenticar()) {
            System.out.println("Pagamento com PayPal no valor de " + valor + " processado com sucesso");
        } 
        else {
            throw new AutenticacaoException("Autenticacao falhou para pagar" + valor + " com PayPal");
        }
    }
}
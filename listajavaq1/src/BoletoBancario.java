//Classe BoletoBancario
public class BoletoBancario implements FormaDePagamento {
    private String codigoBoleto;

    public BoletoBancario(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public boolean autenticar() {
        boolean b = codigoBoleto.equals("12345678");
        return b;
    }

    @Override
    public void processarPagamento(double valor) throws AutenticacaoException {
        if (autenticar()) {
            System.out.println("Pagamento com boleto bancário no valor de " + valor + " processado com sucesso");
        } 
        else {
            throw new AutenticacaoException("Autenticacao falhou para pagar " + valor + " com boleto bancario");
        }
    }
}
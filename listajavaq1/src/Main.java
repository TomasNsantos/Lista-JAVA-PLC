import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AutenticacaoException {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
   do{
            System.out.println("Escolha o método de pagamento desejado:");
            System.out.println("1 - Cartão de Crédito");
            System.out.println("2 - Boleto Bancário");
            System.out.println("3 - PayPal");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            FormaDePagamento formaDePagamento = null;

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a senha do cartão: ");
                    String senhaCartao = scanner.nextLine();
                    System.out.print("Digite o código de segurança: ");
                    String codigoSeguranca = scanner.nextLine();
                    formaDePagamento = new CartaoCredito(senhaCartao, codigoSeguranca);
                }
                case 2 -> {
                    System.out.print("Digite o código do boleto: ");
                    String codigoBoleto = scanner.nextLine();
                    formaDePagamento = new BoletoBancario(codigoBoleto);
                }
                case 3 -> {
                    System.out.print("Digite o login do PayPal: ");
                    String loginPayPal = scanner.nextLine();
                    System.out.print("Digite a senha do PayPal: ");
                    String senhaPayPal = scanner.nextLine();
                    formaDePagamento = new PayPal(loginPayPal, senhaPayPal);
                }
                case 4 -> {
                    System.out.println("Saindo do programa");
                    System.exit(1);
                }
                default -> {
                    System.out.println("Opção inválida,tente de novo: ");
                }
            }
            System.out.print("Digite o valor do pagamento: ");
            double valorPagamento = scanner.nextDouble();

            try {
                formaDePagamento.processarPagamento(valorPagamento);
            } catch (AutenticacaoException e) {
                System.out.println(e.getMessage());
            }
   } while(opcao != 4);
        }

    }
}
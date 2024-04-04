import java.util.Scanner;

public class contaBancaria {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        String nomeCliente = "Murilo Domingues";
        String tipoConta = "Corrente";
        double valorSaldo = 2500;
        int opcao = 0;

        String operacao = """
                Operações
                
                1 - Consultar saldos
                2 - Depositar valores
                3 - Transferir valores
                4 - Sair
                
                Digite a opção desejada:
                """;

        System.out.println(String.format("""
                ******************************************************
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      R$ %.2f
                ******************************************************
                """, nomeCliente, tipoConta, valorSaldo));



        while (opcao != 4) {
            System.out.println(operacao);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(String.format("O saldo atual é R$ %.2f", valorSaldo));
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Digite o valor a ser depositado: ");
                    double valorDepositado = leitura.nextDouble();
                    double novoSaldo = valorSaldo + valorDepositado;
                    valorSaldo = novoSaldo;
                    System.out.println(String.format("Seu saldo atualizado é de R$ %.2f", valorSaldo));
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Digite o valor a ser transferido: ");
                    double valorTransferido = leitura.nextDouble();
                    if (valorTransferido <= valorSaldo) {
                        novoSaldo = valorSaldo - valorTransferido;
                        valorSaldo = novoSaldo;
                        System.out.println(String.format("Seu saldo atualizado é de R$ %.2f", valorSaldo));
                        System.out.println("");
                    } else {
                        System.out.println("Valor a ser transferido é maior que o saldo em conta.");
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("Opção Invalida");
                    System.out.println("");
                    break;
            }
        }
        System.out.println("Obrigado por usar nossos serviços!");
    }
}

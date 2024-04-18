package murilo.calculadoraDeCompras.Principal;

import murilo.calculadoraDeCompras.Calculadora.Compra;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        double valorLimite = 0;

        int opcao = 2;

        List<Compra> listaCompras = new LinkedList<>();

        String menuInicial = """
            Calculadora de Gastos
            
            Digite o valor de limite do cartão:""";

        String menuAdicao = "Digite 0 para encerrar ou 1 para adicionar mais algum item";

        String erro = "Saldo Insuficiente!";

        System.out.println(menuInicial);
        valorLimite = leitura.nextDouble();

        System.out.println("Digite a descrição da compra");
        String produto = leitura.next();
        System.out.println("Digite o valor da compra");
        double valorProduto = leitura.nextDouble();

        Compra compra = new Compra(produto, valorProduto);

        if(valorLimite >= valorProduto){
            listaCompras.add(compra);
            valorLimite -= valorProduto;
            System.out.println("Compra realizada!");
        } else {
            System.out.println(erro);
        }

        while (opcao != 0){
            System.out.println(menuAdicao);
            opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.println("Digite a descrição da compra");
                produto = leitura.next();
                System.out.println("Digite o valor da compra");
                valorProduto = leitura.nextDouble();

                compra = new Compra(produto, valorProduto);

                if (valorLimite >= valorProduto) {
                    listaCompras.add(compra);
                    valorLimite -= valorProduto;
                    System.out.println("Compra realizada!");

                } else {
                    System.out.println(erro);
                }
            } else if (opcao == 0) {
                    System.out.println("Obrigado por usar nossos serviços!");
                    listaCompras.sort(Comparator.comparing(Compra::getValorItem));
                    System.out.println("""
                            ***********************************************
                            Compras Realizadas
                            """);
                    for (Compra item : listaCompras) {
                        System.out.println(String.format("%s - R$%.2f", item.getItem(), item.getValorItem()));
                    }
                    System.out.println("""
                                                    
                            ***********************************************""");
                    System.out.println(String.format("Saldo restante: R$%.2f", valorLimite));
            } else {
                System.out.println("Opção Inválida");
                System.out.println("");
            }

        }
    }
}

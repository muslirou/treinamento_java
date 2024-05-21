package murilo.tabelafipe.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import murilo.tabelafipe.model.DadosModelos;
import murilo.tabelafipe.model.DadosVeiculo;
import murilo.tabelafipe.model.Veiculo;
import murilo.tabelafipe.service.ConsumoAPI;
import murilo.tabelafipe.service.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    private ConsumoAPI consumo = new ConsumoAPI();

    private ConverterDados conversor = new ConverterDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("TABELA FIP - OPÇÕES:" +
                "\n 1) Carros" +
                "\n 2) Motos" +
                "\n 3) Caminhões");
        System.out.println("Digite uma das opções para consultar");
        var veiculo = leitura.nextLine();
        String endereco = "";

        if(veiculo.toLowerCase().contains("carr")) {
            endereco = ENDERECO + "carros/marcas";
        } else if (veiculo.toLowerCase().contains("mot")) {
            endereco = ENDERECO + "motos/marcas";
        } else if (veiculo.toLowerCase().contains("caminh")) {
            endereco = ENDERECO + "caminhoes/marcas";
        } else {
            System.out.println("Opção digitada inválida");
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, DadosVeiculo.class);
        marcas.stream()
                .sorted(Comparator.comparing(DadosVeiculo::codigo))
                .forEach(System.out::println);

        System.out.println("Informe um código da marca para consulta");
        var codMarca = leitura.nextLine();

        endereco = endereco + "/" + codMarca + "/modelos";
        json = consumo.obterDados(endereco);

        var modeloLista = conversor.obterDados(json, DadosModelos.class);

        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(DadosVeiculo::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        var nomeVeiculo = leitura.nextLine();

        List<DadosVeiculo> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo do veículo para buscar os valores de avaliação: ");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<DadosVeiculo> anos = conversor.obterLista(json, DadosVeiculo.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo1 = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo1);
        }

        System.out.println("Todos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);

    }

}

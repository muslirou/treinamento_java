import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import consultaCep.EnderecoViaCep;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Endereco> listaEndereco = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o CEP completo para busca ou digite 'sair' para finalizar");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String site = "http://viacep.com.br/ws/" + busca.replace("-", "") + "/json/";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(site))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                EnderecoViaCep meuEnderecoViaCep =gson.fromJson(json, EnderecoViaCep.class);
                Endereco meuEndereco = new Endereco(meuEnderecoViaCep);

                if(meuEndereco.getCep() != null){
                    System.out.println(meuEndereco);

                    listaEndereco.add(meuEndereco);
                } else {
                    System.out.println("CEP incorreto");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(gson.toJson(listaEndereco));
        escrita.close();

        System.out.println("Operação finalizada");
    }
}
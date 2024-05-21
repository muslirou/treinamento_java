package murilo.tabelafipe;

import murilo.tabelafipe.model.DadosVeiculo;
import murilo.tabelafipe.principal.Principal;
import murilo.tabelafipe.service.ConsumoAPI;
import murilo.tabelafipe.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelafipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelafipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();

		principal.exibeMenu();

	}
}

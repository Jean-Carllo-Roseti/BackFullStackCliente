package br.com.jcmar.cadastroClientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.jcmar.cadastroClientes")
public class CadastroClientesApplication {
	public static void main(String[] args) {
		SpringApplication.run(CadastroClientesApplication.class, args);
	}
}


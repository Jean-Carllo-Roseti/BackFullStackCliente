package br.com.jcmar.cadastroClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteServiceTeste {

    @Autowired
    private ClienteService clienteService;


//@BeforeEach
//void setUp() {
//
//ClienteModel clienteInicial = new ClienteModel("Maria", "Silva", "mariaSilva@gmail.com", 22,
//        "A.V Mascarenhas de Morais", "São Vicente", "SP");
//        clienteService.criarCliente(clienteInicial);
//}

    @Test
    void criarCliente() {
        ClienteModel novoCliente = new ClienteModel("Jean", "Roseti", "jeanrosete04@gmail.com", 31, "Rua Frei Caneca 750", "São Paulo", "SP");

        ClienteModel criadoCliente =  clienteService.criarCliente(novoCliente);

        assertEquals ("Jean", criadoCliente.getNome());
        assertEquals("Roseti", criadoCliente.getSobreNome());
        assertEquals("jeanrosete04@gmail.com", criadoCliente.getEmail());
        assertEquals(31, criadoCliente.getIdade());
        assertEquals("Rua Frei Caneca 750", criadoCliente.getEndereco());
        assertEquals("São Paulo", criadoCliente.getCidade());
        assertEquals("SP", criadoCliente.getEstado());
    }
}

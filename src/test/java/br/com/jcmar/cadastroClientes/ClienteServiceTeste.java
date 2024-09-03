package br.com.jcmar.cadastroClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteServiceTeste {

    @Autowired
    private ClienteService clienteService;

    private ClienteModel clienteInicial;


@BeforeEach
void setUp() {

 clienteInicial = new ClienteModel("Maria", "Silva", "mariaSilva@gmail.com", 22,
        "A.V Mascarenhas de Morais", "São Vicente", "SP");
        clienteService.criarCliente(clienteInicial);
}

    @Test
    void criarClienteTeste() {
        ClienteModel novoCliente = new ClienteModel("Jean", "Roseti", "jeanrosete04@gmail.com", 31, "Rua Frei Caneca 750", "São Paulo", "SP");

        ClienteModel criadoCliente =  clienteService.criarCliente(novoCliente);

        assertThat(criadoCliente).isNotNull();
        assertThat(criadoCliente.getId()).isGreaterThan(0);

        assertEquals ("Jean", criadoCliente.getNome());
        assertEquals("Roseti", criadoCliente.getSobreNome());
        assertEquals("jeanrosete04@gmail.com", criadoCliente.getEmail());
        assertEquals(31, criadoCliente.getIdade());
        assertEquals("Rua Frei Caneca 750", criadoCliente.getEndereco());
        assertEquals("São Paulo", criadoCliente.getCidade());
        assertEquals("SP", criadoCliente.getEstado());
    }

    @Test
    void consultarClienteTeste() {

            Optional<ClienteModel> clienteEncontradoOptional = clienteService.obterClientePorId(clienteInicial.getId());
            assertThat(clienteEncontradoOptional).isPresent();
            ClienteModel clienteEncotrado = clienteEncontradoOptional.get();

            assertThat(clienteEncotrado.getNome()).isEqualTo("Maria");
        }


    @Test
    void EditarClienteTeste() {

    }


}

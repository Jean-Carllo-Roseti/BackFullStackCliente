package br.com.jcmar.cadastroClientes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ClienteServiceMockTeste {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteModel clienteInicial;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        clienteInicial = new ClienteModel("Maria", "Silva", "mariaSilva@gmail.com", 22,
                "A.V Mascarenhas de Morais", "São Vicente", "SP");
        clienteInicial.setId(1L);  // Defina um ID fictício para o cliente inicial

        // Configurando o mock para o método `save`
        when(clienteRepository.save(any(ClienteModel.class))).thenAnswer(invocation -> {
            ClienteModel cliente = invocation.getArgument(0);
            cliente.setId(1L);  // Defina um ID fictício quando o cliente for salvo
            return cliente;
        });

        // Configurando o mock para o método `findById`
        when(clienteRepository.findById(clienteInicial.getId())).thenReturn(Optional.of(clienteInicial));

        // Configurando o mock para o método `existsById`
        when(clienteRepository.existsById(clienteInicial.getId())).thenReturn(true);
    }


    @Test
    void criarClienteTeste() {
        ClienteModel novoCliente = new ClienteModel("Jean", "Roseti", "jeanrosete04@gmail.com", 31, "Rua Frei Caneca 750", "São Paulo", "SP");

        ClienteModel criadoCliente = clienteService.criarCliente(novoCliente);

        assertThat(criadoCliente).isNotNull();
        assertThat(criadoCliente.getId()).isGreaterThan(0);

        verify(clienteRepository, times(1)).save(novoCliente);
    }

    @Test
    void consultarClienteTeste() {
        Optional<ClienteModel> clienteEncontrado = clienteService.obterClientePorId(clienteInicial.getId());

        assertThat(clienteEncontrado).isPresent();
        ClienteModel cliente = clienteEncontrado.get();
        assertThat(cliente.getNome()).isEqualTo("Maria");
    }

    @Test
    void editarClienteTeste() {
        clienteInicial.setNome("Maria Aparecida");
        when(clienteRepository.save(clienteInicial)).thenReturn(clienteInicial);

        ClienteModel clienteAtualizado = clienteService.atualizarCliente(clienteInicial.getId(), clienteInicial);

        assertThat(clienteAtualizado.getNome()).isEqualTo("Maria Aparecida");
        verify(clienteRepository, times(1)).save(clienteInicial);
    }

    @Test
    void deletarClienteTeste() {
        clienteService.removerCliente(clienteInicial.getId());

        verify(clienteRepository, times(1)).deleteById(clienteInicial.getId());
    }
}

package br.com.jcmar.cadastroClientes.Service;

import br.com.jcmar.cadastroClientes.Model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    ClienteModel criarCliente (ClienteModel clienteModel);
    Optional<ClienteModel> obterClientePorId (Long id);
    ClienteModel atualizarCliente(Long id, ClienteModel clienteModel);
    void removerCliente (long id);
    List<ClienteModel> listarCliente();
}

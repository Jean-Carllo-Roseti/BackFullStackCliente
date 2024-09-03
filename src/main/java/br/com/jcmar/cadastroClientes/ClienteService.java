package br.com.jcmar.cadastroClientes;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClienteService implements IClienteService {


    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public ClienteModel criarCliente(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    @Override
    public Optional<ClienteModel> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteModel) {
        if (clienteRepository.existsByID(id)) {
            cliente.setId(id);
            return clienteModel.save(clienteModel);
        }
        return null;
    }

    @Override
    public void removerCliente(long id) {
        clienteRepository.deleteById(id);
    }
}

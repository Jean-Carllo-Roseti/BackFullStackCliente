package br.com.jcmar.cadastroClientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

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
        if (clienteRepository.existsById(id)) {
            clienteModel.setId(id);
            return clienteRepository.save(clienteModel);
        }
        return null;
    }

    @Override
    public void removerCliente(long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteModel> listarCliente() {
        return clienteRepository.findAll();
    }
}

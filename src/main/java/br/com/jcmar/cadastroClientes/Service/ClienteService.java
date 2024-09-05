package br.com.jcmar.cadastroClientes.Service;

import br.com.jcmar.cadastroClientes.Model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {


    @Autowired
    private br.com.jcmar.cadastroClientes.Repository.IClienteRepository IClienteRepository;

    @Override
    public ClienteModel criarCliente(ClienteModel clienteModel) {
        return IClienteRepository.save(clienteModel);
    }

    @Override
    public Optional<ClienteModel> obterClientePorId(Long id) {
        return IClienteRepository.findById(id);
    }

    @Override
    public ClienteModel atualizarCliente(Long id, ClienteModel clienteModel) {
        if (IClienteRepository.existsById(id)) {
            clienteModel.setId(id);
            return IClienteRepository.save(clienteModel);
        }
        return null;
    }

    @Override
    public void removerCliente(long id) {
        IClienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteModel> listarCliente() {
        return IClienteRepository.findAll();
    }
}

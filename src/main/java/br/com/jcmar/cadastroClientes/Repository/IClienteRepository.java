package br.com.jcmar.cadastroClientes.Repository;

import br.com.jcmar.cadastroClientes.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {

}

package br.com.jcmar.cadastroClientes;


import org.junit.jupiter.api.Test;

public class TesteClienteService {
    @Test
    void criarCliente() {
        ClienteModel clienteModel = new ClienteModel("Jean", "Roseti", "jeanrosete04@gmail.com", 31, "Rua Frei Caneca 750", "São Paulo", "Sp");
        ClienteModel criarClienteModel = ClienteService.criarCliente(clienteModel);

        AssertEquals("Jean", criarClienteModel.getName());
        AssertEquals("Roseti", criarClienteModel.getLastName());
        AssertEquals("jeanrosete04@gmail.com", criarClienteModel.getEmail());
        AssertEquals(31, criarClienteModel.getIdade());
        AssertEquals("Rua Frei Caneca 750", criarClienteModel.getEndenresso());
        AssertEquqls("São Paulo", criarClienteModel.getCidade());
        AssertEquals("SP", criarClienteModel.getCidade());
    }
}

package br.com.jcmar.cadastroClientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAllClientes() {
        List<ClienteModel> clientes = clienteService.listarCliente();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getClienteById(@PathVariable Long id) {
        Optional<ClienteModel> cliente = clienteService.obterClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteModel> createCliente(@RequestBody ClienteModel cliente) {
        ClienteModel novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable Long id, @RequestBody ClienteModel cliente) {
        ClienteModel clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return clienteAtualizado != null ? ResponseEntity.ok(clienteAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }
}

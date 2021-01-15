package com.vsmoura.os.domain.service;

import com.vsmoura.os.domain.exception.NegocioException;
import com.vsmoura.os.domain.model.Cliente;
import com.vsmoura.os.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);
    }

    public void remover(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

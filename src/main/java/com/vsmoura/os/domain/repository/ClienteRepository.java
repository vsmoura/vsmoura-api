package com.vsmoura.os.domain.repository;

import com.vsmoura.os.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}

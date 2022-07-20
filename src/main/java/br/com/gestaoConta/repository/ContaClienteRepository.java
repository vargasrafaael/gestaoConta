package br.com.gestaoConta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestaoConta.model.ContaCliente;

public interface ContaClienteRepository extends JpaRepository<ContaCliente, Long>{
	
	@Query(value = "select cc from ContaCliente cc where cc.cpf = :cpf")
	public ContaCliente findByCpf(@Param("cpf") String cpf);
}
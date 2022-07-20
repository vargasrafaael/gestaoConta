package br.com.gestaoConta.service;

import org.springframework.stereotype.Service;

import br.com.gestaoConta.model.ContaCliente;

@Service
public interface ContaClienteService {
	
	public void save(ContaCliente entity);
	public void update(ContaCliente entity);
	public ContaCliente findByCpf(String cpf);
	public void delete(String cpf);
}
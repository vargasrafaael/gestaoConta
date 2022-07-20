package br.com.gestaoConta.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gestaoConta.model.ContaCliente;
import br.com.gestaoConta.model.EnumSituacaoConta;
import br.com.gestaoConta.repository.ContaClienteRepository;
import br.com.gestaoConta.service.ContaClienteService;

public class ContaClienteServiceImpl implements ContaClienteService{
	
	@Autowired
	private ContaClienteRepository repository;

	@Override
	public void save(ContaCliente entity) {
		repository.save(entity);
	}

	@Override
	public void update(ContaCliente entity) {
		ContaCliente contaClienteAux = this.findByCpf(entity.getCpf());
		entity.setId(contaClienteAux.getId());
		this.save(entity);
	}

	@Override
	public ContaCliente findByCpf(String cpf) {
		ContaCliente entity = repository.findByCpf(cpf);
		
		if(entity == null)
			throw new IllegalArgumentException("Ciente não encontrado pelo CPF.");
		
		return entity;
	}

	@Override
	public void delete(String cpf) {
		ContaCliente entity = this.findByCpf(cpf);
		entity.setSituacaoConta(EnumSituacaoConta.CANCELADO);
		this.save(entity);
	}

}

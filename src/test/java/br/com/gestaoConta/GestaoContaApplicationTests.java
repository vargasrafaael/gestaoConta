package br.com.gestaoConta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gestaoConta.model.ContaCliente;
import br.com.gestaoConta.model.EnumSituacaoConta;
import br.com.gestaoConta.service.ContaClienteService;

@SpringBootTest
class GestaoContaApplicationTests {
	
	@Autowired
	private ContaClienteService service;

	@Test
	void testeSalvar() {
		ContaCliente conta = new ContaCliente();
		conta.setAgencia("1111");
		conta.setConta("12121");
		conta.setCpf("11111111111");
		conta.setDigito("1");
		conta.setNome("Rafael teste");
		conta.setSituacaoConta(EnumSituacaoConta.ATIVO);
		
		service.save(conta);
		
		assertNotNull(service.findByCpf(conta.getCpf()));
	}
	
	@Test
	void testeEditar() {
		ContaCliente conta = new ContaCliente();
		conta.setAgencia("1111");
		conta.setConta("12121");
		conta.setCpf("11111111111");
		conta.setDigito("1");
		conta.setNome("Rafael teste ateracao nome");
		conta.setSituacaoConta(EnumSituacaoConta.ATIVO);
	
		ContaCliente contaAux = service.findByCpf(conta.getCpf());
		assertEquals(conta.getNome(), contaAux.getNome());
	}
	
	@Test
	void testeDelete() {
		ContaCliente conta = new ContaCliente();
		conta.setAgencia("1111");
		conta.setConta("12121");
		conta.setCpf("11111111111");
		conta.setDigito("1");
		conta.setNome("Rafael teste");
		conta.setSituacaoConta(EnumSituacaoConta.ATIVO);
		
		service.delete(conta.getCpf());
		ContaCliente contaAux = service.findByCpf(conta.getCpf());
		assertEquals(contaAux.getSituacaoConta(), EnumSituacaoConta.CANCELADO);
	}
	
	@Test
	void testeBuscar() {
		ContaCliente conta = new ContaCliente();
		conta.setAgencia("1111");
		conta.setConta("12121");
		conta.setCpf("11111111111");
		conta.setDigito("1");
		conta.setNome("Rafael teste");
		conta.setSituacaoConta(EnumSituacaoConta.ATIVO);
		
		assertNotNull(service.findByCpf(conta.getCpf()));
	}
}
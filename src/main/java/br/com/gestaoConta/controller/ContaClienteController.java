package br.com.gestaoConta.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaoConta.exception.MessageResponse;
import br.com.gestaoConta.model.ContaCliente;
import br.com.gestaoConta.service.ContaClienteService;

@RestController
@RequestMapping("/cliente/gestao-conta")
public class ContaClienteController {

	@Autowired
	private ContaClienteService service;
	
	@PostMapping
	public ResponseEntity<MessageResponse> saveCliente(@PathVariable("x-request-id") String requestId, @RequestBody @Valid ContaCliente conta) throws Exception{
		service.save(conta);
		return ResponseEntity.ok().body(new MessageResponse(new Date(), "Ação realizada com sucesso.", HttpStatus.OK.value()));
	}
	
	@PutMapping
	public ResponseEntity<MessageResponse> updateCliente(@PathVariable("x-request-id") String requestId, @RequestBody @Valid ContaCliente conta) throws Exception{
		service.update(conta);
		return ResponseEntity.ok().body(new MessageResponse(new Date(), "Ação realizada com sucesso.", HttpStatus.OK.value()));
	}
	
	@GetMapping
	public ResponseEntity<ContaCliente> getCliente(@PathVariable("x-request-id") String requestId, @PathVariable("cpf") String cpf) throws Exception{
		ContaCliente conta = service.findByCpf(cpf);
		return ResponseEntity.ok().body(conta); 
	}
	
	@DeleteMapping
	public ResponseEntity<MessageResponse> deleteCliente(@PathVariable("x-request-id") String requestId, @PathVariable("cpf") String cpf) throws Exception{
		service.delete(cpf);
		return ResponseEntity.ok().body(new MessageResponse(new Date(), "Ação realizada com sucesso.", HttpStatus.OK.value()));
	}
}

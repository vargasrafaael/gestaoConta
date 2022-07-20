package br.com.gestaoConta.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CONTA_CLIENTE")
public class ContaCliente implements Serializable{
	
	private static final long serialVersionUID = 8631043410381962922L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonIgnore
	private Long id;
	
	@NotNull(message = "Informe o campo agência.")
	@NotEmpty(message = "Informe o campo agência.")
	@Size(min = 4, max = 4, message = "O CPF deve conter 11 digitos")
	@Column(name = "AGENCIA")
	private String agencia;
	
	@NotNull(message = "Informe o campo conta.")
	@NotEmpty(message = "Informe o campo conta.")
	@Size(min = 5, max = 5, message = "A conta deve conter 5 digitos")
	@Column(name = "CONTA")
	private String conta;
	
	@NotNull(message = "Informe o campo digito.")
	@NotEmpty(message = "Informe o campo digito.")
	@Size(min = 1, max = 1, message = "O digito deve conter 1 digito")
	@Column(name = "DIGITO")
	private String digito;
	
	@NotNull(message = "Informe o campo CPF.")
	@NotEmpty(message = "Informe o campo CPF.")
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 digitos")
	@Column(name = "CPF")
	private String cpf;
	
	@NotNull(message = "Informe o campo nome.")
	@NotEmpty(message = "Informe o campo nome.")
	@Size(min = 1, max = 30)
	@Column(name = "NOME")
	private String nome;
	
	@NotNull(message = "Informe o campo situação da conta.")
	@NotEmpty(message = "Informe o campo situação da conta.")
	@Size(min = 1, max = 10)
	@Column(name = "SITUACAO_CONTA")
	private EnumSituacaoConta situacaoConta;
	
	@Size(max = 100)
	@Column(name = "OBSERVACOES")
	private String observacoes;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCliente other = (ContaCliente) obj;
		return Objects.equals(id, other.id);
	}
}
package br.com.gestaoConta.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageResponse implements Serializable{

	private static final long serialVersionUID = 68007008681095561L;

	private Date timestamp;
	private String mensagem;
	private Integer statusCode;
}
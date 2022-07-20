package br.com.gestaoConta.model;

public enum EnumSituacaoConta {

	ATIVO	  ("ATIVO"),
	CANCELADO ("CANCELADO");
	
	private String valor;

	EnumSituacaoConta(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
}

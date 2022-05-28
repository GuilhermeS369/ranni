package com.ranni.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;
	// CONSTRUTOR PADRÃO
	private OrderStatus(int code) {
		this.code = code;
	}
	// METODO PARA OBTER O CODE
	public int getCode() {
		return code;
	}

	// CONVERTE VALOR NUMERO PARA TIPO ENUMRADO
	// STATICO PARA FUNCIONAR SEM PRECISAR INSTANCIAR
	// AQUI VAMOS PASSAR UM CODIGO E VAI RETORNAR O ESTADO CORRESPONDENTE
	public static OrderStatus valueOf(int code) {
		// PERCORRE TODOS OS ESTADOS ATE ACHAR O CORRESPONDENTE
		// E O RETORNA NO PROPRIO METODO
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		// TRATAMENTO CASO NAO HAJA NENHUM NUMERO COMAPATIVEL
		throw new IllegalArgumentException("INVALID OrderStatus code");
	}
}

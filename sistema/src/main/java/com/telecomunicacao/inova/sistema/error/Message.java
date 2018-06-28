package com.telecomunicacao.inova.sistema.error;


public class Message {
	private String message;
	
	public String getMessage() {
		return message;
	}

	
	public Message(int numero) {
		
		switch(numero) {
			case 404:
				System.out.println("Numero >> " + numero);
				message = " não encontrado, erro " + numero; //quando não consegue se comunicar com o servidor;
				break;
			case 2:
				System.out.println("Numero >> " + numero);
				message = "Desculpe o transtorno, servidor em !" + numero; //quando não consegue se comunicar com o servidor;
				break;
			case 3:
				System.out.println("Numero >> " + numero);
				message = "Desculpe o transtorno, servidor !" + numero; //quando não consegue se comunicar com o servidor;
				break;
			default:
				System.out.println("Numero errado" + numero);
				message = "Desculpe o transtorno !" + numero; //quando não consegue se comunicar com o servidor;
				break;
		}
	}
	
	public Message() {
		super();
	}
	
}

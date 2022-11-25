package model.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecao {

	Scanner sc = new Scanner(System.in);
	
	public char verificarCaractere() {
		char resposta;
		do {
			
			resposta = sc.next().charAt(0);
			while (resposta != 's' && resposta != 'n') {
				System.out.println("Caracter inválido, digite novamente (s/n):");
				resposta = sc.next().charAt(0);
			}
		} while (resposta != 's' && resposta != 'n');	
		return resposta;
	}
	
	public Integer verificarQuantidadeJogos() {
		Integer numeroDeJogos = 0;
		Boolean teste = true;
		System.out.println("Insira a quantidade de jogos aleatórios que deseja fazer: ");
			do {  
				try {
					numeroDeJogos = sc.nextInt();				
					while(numeroDeJogos <= 0) {
						System.out.println("Número inválido, insira novamente:");
						numeroDeJogos = sc.nextInt();
					}
					teste = false;
				} catch (InputMismatchException err) {
					System.out.println("Numero inválido, insira novamente:");
					sc.nextLine();
				} 

			} while(teste == true);		
		return numeroDeJogos;
	}
	
	public Integer verificarNumeroEscolhido() {
		Integer numero = 0;
		Boolean teste = true;
		do {  
			try {
				numero = sc.nextInt();
				teste = false;
			} catch (InputMismatchException err) {
				System.out.printf("%nNumero inválido, insira novamente (1 a 60):%n");
				sc.nextLine();
			} 

		} while(teste == true);		
	return numero;
		
	}
}
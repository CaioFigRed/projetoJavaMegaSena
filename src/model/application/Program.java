package model.application;

import model.entities.Concurso;
import model.entities.Participantes;
import model.util.Excecao;
import model.util.Mensagem;

public class Program {

	public static void main(String[] args) {

		System.out.println("Mega Sena");
		
		char resposta;
		Excecao excecao = new Excecao();
		Concurso concurso = new Concurso();
		Mensagem mensagem = new Mensagem();
		do {
			do {
				System.out.printf("%nDeseja criar participante? (s/n)%n");
				resposta = excecao.verificarCaractere();
				if( resposta == 's') {
					new Participantes();
					mensagem.mostrarParticipante();

				}
			} while (resposta == 's');
			mensagem.mostrarPremiacao();
			System.out.println("Deseja criar um novo concurso? (s/n)");
			resposta = excecao.verificarCaractere();
			if (resposta == 's') {
				concurso.novoConcurso();
			}
			
		} while (resposta =='s');
		System.out.println("Mega-Sena Finalizada");
	}

}

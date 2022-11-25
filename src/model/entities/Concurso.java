package model.entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.util.Excecao;
import model.util.Mensagem;
import model.util.Verificacao;

public class Concurso {
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Participantes> participantes = new ArrayList<Participantes>();
	ArrayList<Premio> premios = new ArrayList<Premio>();
	static ArrayList<Integer> numerosSorteados = new ArrayList<Integer>(6);
	static Integer qtdJogos = 0;
	static Integer id = 0;
	
	public Participantes getParticipantes(int id) {
		return participantes.get(id);
	}
	
	public ArrayList<Participantes> getParticipantes() {
		return participantes;
	}

	public ArrayList<Premio> getPremios() {
		return premios;
	}

	public ArrayList<Integer> getNumerosSorteados() {
		return numerosSorteados;
	}

	public Integer getNumerosSorteados(int id) {
		return numerosSorteados.get(id);
	}
	
	public Integer getQtdJogos() {
		return qtdJogos;
	}

	static ArrayList<ArrayList<Integer>> criarAposta() {
		ArrayList<ArrayList<Integer>> listaJogos = new ArrayList<ArrayList<Integer>>();
		char resposta ='s';
		Mensagem mensagem = new Mensagem();
		Excecao excecao = new Excecao();
		
		do {
			resposta = mensagem.mensagemCriarAposta();
			if(resposta == 's') {
				listaJogos.addAll(criarApostaAleatoria(excecao.verificarQuantidadeJogos()));
			} else {
				listaJogos.add(criarApostaEscolhida());
				qtdJogos++;

			}
			System.out.println("Deseja criar novo jogo? (s/n)");
			resposta = excecao.verificarCaractere();
		} while(resposta == 's');
		return listaJogos;
	}
	
	private static ArrayList<ArrayList<Integer>> criarApostaAleatoria(Integer numeroDeJogos) {
		ArrayList<ArrayList<Integer>> listaApostas = new ArrayList<ArrayList<Integer>>();
		Random random = new Random();	
		Integer num,cont = 0;
		do {
			ArrayList<Integer> jogo = new ArrayList<Integer>();

			for (int i = 0; i < 6; i++) {
				do {
					num = random.nextInt(1,61);
				} while (jogo.contains(num));
				jogo.add(num);
			}
			listaApostas.add(jogo);
			cont++;
		} while (cont < numeroDeJogos);	
		qtdJogos += numeroDeJogos;
		return listaApostas;
	}
	
	private static ArrayList<Integer> criarApostaEscolhida () {
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		Excecao excecao = new Excecao();
		Integer num;
		
		for (int i = 0; i < 6; i++) {
			System.out.println("Numeros escolhidos até o momento:");
			System.out.println(jogo);
			System.out.printf("Digite o número escolhido (1 a 60):%n");
			num = excecao.verificarNumeroEscolhido();
			while (num > 60 || num < 1 || jogo.contains(num)) {
				System.out.println("Numeros escolhidos até o momento:");
				System.out.println(jogo);
				System.out.printf("Número inválido, digite novamente (1 a 60):%n");
				num = excecao.verificarNumeroEscolhido();
			}
			jogo.add(num);
		}
		System.out.println("Aposta criada:");
		System.out.println(jogo);


		return jogo;
	}
	
	public void sortearNumeros() {
		Random random = new Random();
		int num;
		
		for(int i = 0; i < 6; i++) {
			do {
				num = random.nextInt(1,61);
			} while (numerosSorteados.contains(num));
			numerosSorteados.add(num);
		}		
	}

	public void novoConcurso() {
		Premio premio =  new Premio();
		Verificacao verificacao = new Verificacao();
		if (!(verificacao.getGanhadorSena().isEmpty())) {
			premio.setSena(0.0);
		}
		if (!(verificacao.getGanhadorQuina().isEmpty())) {
			premio.setQuina(0.0);
		}
		if (!(verificacao.getGanhadorQuadra().isEmpty())) {
			premio.setQuadra(0.0);
		}
		verificacao.getGanhadorSena().clear();
		verificacao.getGanhadorQuina().clear();
		verificacao.getGanhadorQuadra().clear();
		verificacao.getVencedorQuina().clear();
		verificacao.getVencedorQuadra().clear();
		getNumerosSorteados().clear();
		participantes.clear();
		id = 0;
		qtdJogos = 0;

	}
}

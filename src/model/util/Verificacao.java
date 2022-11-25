package model.util;

import java.util.ArrayList;

import model.entities.Concurso;

public class Verificacao {

	private static ArrayList<Integer> ganhadorSena = new ArrayList<Integer>();
	private static ArrayList<Integer> ganhadorQuina = new ArrayList<Integer>();
	private static ArrayList<Integer> ganhadorQuadra = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> vencedorSena = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<ArrayList<Integer>> vencedorQuina = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<ArrayList<Integer>> vencedorQuadra = new ArrayList<ArrayList<Integer>>();
	
	
	public ArrayList<Integer> getGanhadorSena() {
		return ganhadorSena;
	}


	public ArrayList<Integer> getGanhadorQuina() {
		return ganhadorQuina;
	}


	public ArrayList<Integer> getGanhadorQuadra() {
		return ganhadorQuadra;
	}


	public ArrayList<ArrayList<Integer>> getVencedorSena() {
		return vencedorSena;
	}


	public ArrayList<ArrayList<Integer>> getVencedorQuina() {
		return vencedorQuina;
	}


	public ArrayList<ArrayList<Integer>> getVencedorQuadra() {
		return vencedorQuadra;
	}


	public void ganhadores () {
		int soma = 0, quantidadeJogadores;
		Concurso concurso = new Concurso();
		quantidadeJogadores = concurso.getParticipantes().size();


		for (int i = 0; i < quantidadeJogadores; i++) {
			for (int j = 0; j < concurso.getParticipantes(i).getApostas().size(); j++) {
				for (int cont = 0; cont < 6; cont++) {
					if (concurso.getParticipantes(i).getApostas(j).contains(concurso.getNumerosSorteados(cont))) {
						soma++;
					}
				}
				if (soma == 6) {
					vencedorSena.add(concurso.getParticipantes(i).getApostas(j));
					ganhadorSena.add(concurso.getParticipantes(i).getId());
				}
				if (soma == 5) {
					vencedorQuina.add(concurso.getParticipantes(i).getApostas(j));
					ganhadorQuina.add(concurso.getParticipantes(i).getId());
				} else if (soma == 4) {
					vencedorQuadra.add(concurso.getParticipantes(i).getApostas(j));
					ganhadorQuadra.add(concurso.getParticipantes(i).getId());
				}
				soma = 0;
			}
		}
	}	
}

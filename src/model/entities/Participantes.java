package model.entities;

import java.util.ArrayList;

public class Participantes {
	
	ArrayList<ArrayList<Integer>> apostas = new ArrayList<ArrayList<Integer>>();
	Integer id;
	
	public Participantes() {
		int identificador;
		identificador = Concurso.id + 1;
		Concurso.participantes.add(new Participantes(Concurso.criarAposta(), identificador));
		Concurso.id ++;
	}
	
	public Participantes(ArrayList<ArrayList<Integer>> apostas, Integer id) {
		this.apostas = apostas;
		this.id = id;
	}
	
	public ArrayList<ArrayList<Integer>> getApostas() {
		return apostas;
	}
	
	public ArrayList<Integer> getApostas(int id) {
		return apostas.get(id);
	} 
	
	public Integer getId() {
		return id;
	}
	
	
}

package model.entities;

import model.util.Verificacao;

public class Premio {

	static Double sena = 0.0, quina = 0.0, quadra = 0.0, arrecadacaoTotal = 0.0, premioBruto = 0.0;
	
	public void valorPremiacao() {
		Verificacao verificacao = new Verificacao();
		Concurso concurso = new Concurso();
		arrecadacaoTotal = (double) (concurso.getQtdJogos() * 6);
		premioBruto = arrecadacaoTotal * 0.4335;
		sena = getSena() + premioBruto * 0.35;
		quina += premioBruto * 0.19;
		quadra += premioBruto * 0.19;
		
		if (!(verificacao.getGanhadorSena().isEmpty())) {
			sena = 0.0;			
		}
		if (!(verificacao.getGanhadorQuina().isEmpty())) {
			quina = 0.0;
		}
		if (!(verificacao.getGanhadorQuadra().isEmpty())) {
			quadra = 0.0;
		}
	}
	


	public Double getSena() {
		return sena;
	}

	public Double getQuina() {
		return quina;
	}

	public Double getQuadra() {
		return quadra;
	}

	public Double getArrecadacaoTotal() {
		return arrecadacaoTotal;
	}

	public static Double getPremioBruto() {
		return premioBruto;
	}



	public void setSena(Double sena) {
		Premio.sena = sena;
	}



	public void setQuina(Double quina) {
		Premio.quina = quina;
	}



	public void setQuadra(Double quadra) {
		Premio.quadra = quadra;
	}
	
	
}

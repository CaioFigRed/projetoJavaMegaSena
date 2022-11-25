package model.util;

import model.entities.Concurso;
import model.entities.Premio;

public class Mensagem {

	public char mensagemCriarAposta() {
		char resposta;
		Excecao excecao = new Excecao();
		
		System.out.println("Deseja utilizar números aleatórios? (s/n)");
		resposta = excecao.verificarCaractere();
		return resposta;
	}

	public void mostrarPremiacao() {
		int apostasGanhadoras = 0;
		Verificacao verificacao = new Verificacao();
		Concurso concurso = new Concurso();
		Premio premio = new Premio();
		
		concurso.sortearNumeros();
		premio.valorPremiacao();
		verificacao.ganhadores();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Mega-Sena");
		System.out.println();
		System.out.println("Bilhete sorteado: ");

		System.out.println(concurso.getNumerosSorteados() + "\n");
		System.out.println("Premiação");
		System.out.println();
		System.out.println("6 acertos: ");
		if (verificacao.getGanhadorSena().isEmpty()) {
			System.out.println("Não houve ganhadores");
			System.out.printf("Acumulado próximo concurso: R$ %.2f%n", premio.getSena());
			System.out.println();
		} else {
			apostasGanhadoras = verificacao.getGanhadorSena().size();
			System.out.printf("%d apostas ganhadoras, R$ %.2f%n",apostasGanhadoras, premio.getSena() / apostasGanhadoras);
			System.out.println(verificacao.getGanhadorSena());
			System.out.println(verificacao.getVencedorSena());
			System.out.println();
		}
		System.out.println("5 acertos: ");
		if (verificacao.getGanhadorQuina().isEmpty()) {
			System.out.println("Não houve ganhadores");
			System.out.printf("Acumulado próximo concurso: R$ %.2f%n", premio.getQuina());
			System.out.println();
		} else {
			apostasGanhadoras = verificacao.getGanhadorQuina().size();
			System.out.printf("%d apostas ganhadoras, R$ %.2f%n",apostasGanhadoras, premio.getQuina() / apostasGanhadoras);
			System.out.printf("Valor total quina: R$ %.2f%n", premio.getQuina());
			System.out.println(verificacao.getGanhadorQuina());
			System.out.println(verificacao.getVencedorQuina());
			System.out.println();
		}
		System.out.println("4 acertos: ");
		if (verificacao.getGanhadorQuadra().isEmpty()) {
			System.out.printf("Não houve ganhadores%n");
			System.out.printf("Acumulado próximo concurso: R$ %.2f%n", premio.getQuadra());
			System.out.println();

		} else {
			apostasGanhadoras = verificacao.getGanhadorQuadra().size();
			System.out.printf("%d apostas ganhadoras, R$ %.2f%n",apostasGanhadoras, premio.getQuadra() / apostasGanhadoras);
			System.out.printf("Valor total quadra: R$ %.2f%n", premio.getQuadra());
			System.out.println(verificacao.getGanhadorQuadra());
			System.out.println(verificacao.getVencedorQuadra());
			System.out.println();
		}
		System.out.printf("Arrecadação Total: R$ %.2f%n%n", premio.getArrecadacaoTotal());
		System.out.println("-----------------------------------------------------------------");
		
	}

	
	 public void mostrarParticipante() {
		 Concurso concurso = new Concurso();
		 Integer id = concurso.getParticipantes().size() - 1;
		 int quantidadeJogos = concurso.getParticipantes(id).getApostas().size();
		 double valorPagar = concurso.getParticipantes(id).getApostas().size() * 6;
		 
		 System.out.printf("%nID: %d%n", id + 1);
		 System.out.println("Jogos realizados:");
		 for (int i = 0; i < quantidadeJogos; i ++) {
			 System.out.println(concurso.getParticipantes(id).getApostas(i));
		 }
		 System.out.printf("%nValor total a pagar: R$ %.2f%n", valorPagar);
	 }
}

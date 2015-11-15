package br.com.jogo;

public class Jogador {
	
	private String nmJogador;
	private Arma arma;
	private int assassinatos;
	private int mortes;
	
	public String getNmJogador() {
		return nmJogador;
	}
	public void setNmJogador(String nmJogador) {
		this.nmJogador = nmJogador;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public int getAssassinatos() {
		return assassinatos;
	}
	public void setAssassinatos(int assassinatos) {
		this.assassinatos = assassinatos;
	}
	public int getMortes() {
		return mortes;
	}
	public void setMortes(int mortes) {
		this.mortes = mortes;
	}
	
	
}

package br.com.jogo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaBean implements Partida {
	
	private Integer numPartida;
	private Calendar inicioPartida;
	private Calendar finalPartida;
	private Map<String,Jogador> jogadoresList = new HashMap<String,Jogador>();
	private List<String> linhasList;
	
	public PartidaBean (List<String> linhasList)  {
		this.linhasList=linhasList;
		
		String[] inicioPartida = linhasList.get(0).split(" ");
		String[] finalPartida = linhasList.get(linhasList.size()-1).split(" ");
		
		setInicioPartida(DecoratorDate.getCalendar(inicioPartida));
		setFinalPartida(DecoratorDate.getCalendar(finalPartida));
		setNumPartida(new Integer(inicioPartida[5]));
		
		linhasList.remove(0);
		linhasList.remove(linhasList.size()-1);
		
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.jogo.Partida#carregarJogadores()
	 */
	@Override
	public void carregarJogadores() {
		Jogador jogador = null;
		Jogador jogadorMorto = null;
		for(String element : this.linhasList){
			jogador = new Jogador();
			jogadorMorto = new Jogador();
			String[] palavras = element.split(" ");
			String nmJogador = palavras[3];
			if(!"<WORLD>".equals(nmJogador)){
				jogador.setNmJogador(nmJogador);
				if(!this.jogadoresList.containsKey(nmJogador)){
					jogador.setAssassinatos(1);
					jogador.setArma(new Arma(palavras[7]));
					jogadoresList.put(nmJogador, jogador);
				}else{
					Jogador newJogador = jogadoresList.get(nmJogador);
					newJogador.setAssassinatos(newJogador.getAssassinatos() +1);
					jogadoresList.remove(newJogador.getNmJogador());
					jogadoresList.put(newJogador.getNmJogador(), newJogador);
				}
				
				
				String nmJogadorMorto = palavras[5];
				if(!jogadoresList.containsKey(nmJogadorMorto)){
					jogadorMorto.setNmJogador(nmJogadorMorto);
					jogadorMorto.setMortes(1);
					jogadoresList.put(nmJogadorMorto, jogadorMorto);
				}else{
					Jogador newJogador = jogadoresList.get(nmJogadorMorto);
					newJogador.setMortes(newJogador.getMortes() +1);
					jogadoresList.remove(newJogador.getNmJogador());
					jogadoresList.put(newJogador.getNmJogador(), newJogador);
				}
			}else{
				String nmJogadorMorto = palavras[5];
				if(!jogadoresList.containsKey(nmJogadorMorto)){
					jogadorMorto.setNmJogador(nmJogadorMorto);
					jogadorMorto.setMortes(1);
					jogadoresList.put(nmJogador, jogadorMorto);
				}else{
					Jogador newJogador = jogadoresList.get(nmJogadorMorto);
					newJogador.setMortes(newJogador.getMortes() +1);
					jogadoresList.remove(newJogador.getNmJogador());
					jogadoresList.put(newJogador.getNmJogador(), newJogador);
				}
				
			}
			
			
		}
	}

	/* (non-Javadoc)
	 * @see br.com.jogo.Partida#imprimirResultado()
	 */
	@Override
	public  void imprimirResultado() {
		System.out.println(" Ranking da partida numero : " + this.numPartida );
		System.out.println(" Inicio da partida         : " + DecoratorDate.formataData(this.inicioPartida));
		System.out.println(" Término da partida        : " + DecoratorDate.formataData(this.finalPartida));
		System.out.println();
		for (String key : jogadoresList.keySet()) {
			  Jogador value = jogadoresList.get(key); 
			  System.out.println("Nome do jogador: " + value.getNmJogador() + " - numero de assassinato: " + value.getAssassinatos() + " - numero de morte: " + value.getMortes());
		}
		
		
	}

	
	
	public List<String> getLinhasList() {
		return linhasList;
	}





	public void setLinhasList(List<String> linhasList) {
		this.linhasList = linhasList;
	}





	public Integer getNumPartida() {
		return numPartida;
	}
	public void setNumPartida(Integer numPartida) {
		this.numPartida = numPartida;
	}
	public Calendar getInicioPartida() {
		return inicioPartida;
	}
	public void setInicioPartida(Calendar inicioPartida) {
		this.inicioPartida = inicioPartida;
	}
	public Calendar getFinalPartida() {
		return finalPartida;
	}
	public void setFinalPartida(Calendar finalPartida) {
		this.finalPartida = finalPartida;
	}
	public Map<String, Jogador> getJogadoresList() {
		return jogadoresList;
	}
	public void setJogadoresList(Map<String, Jogador> jogadoresList) {
		this.jogadoresList = jogadoresList;
	}
	
	
	

}

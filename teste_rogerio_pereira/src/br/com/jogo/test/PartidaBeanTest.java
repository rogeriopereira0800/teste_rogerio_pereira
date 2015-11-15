package br.com.jogo.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import br.com.jogo.LeitorArquivo;
import br.com.jogo.Partida;
import br.com.jogo.PartidaBean;

public class PartidaBeanTest {

	@Test
	public void testPartida() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo();
		List<String> lista = leitor.leitor("partida.log");
		Partida partida =  new PartidaBean(lista);
		assertNotNull(partida);
		
		
	}
	
	@Test
	public void testJogadores() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo();
		List<String> lista = leitor.leitor("partida.log");
		PartidaBean partida =  new PartidaBean(lista);
		partida.carregarJogadores();
		assertNotNull(partida.getJogadoresList());
	}

}

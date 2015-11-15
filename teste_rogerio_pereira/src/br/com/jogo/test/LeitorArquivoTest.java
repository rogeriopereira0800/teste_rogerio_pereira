package br.com.jogo.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import br.com.jogo.LeitorArquivo;

public class LeitorArquivoTest {

	@Test
	public void testEmpty() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo();
		List<String> lista = leitor.leitor("partida.log");
		assertFalse("",lista.isEmpty());
		
	}
	
	@Test
	public void testSize() throws FileNotFoundException {
		LeitorArquivo leitor = new LeitorArquivo();
		List<String> lista = leitor.leitor("partida.log");
		assertTrue
		
		
		
		(lista.size() == 4);
		
	}

}

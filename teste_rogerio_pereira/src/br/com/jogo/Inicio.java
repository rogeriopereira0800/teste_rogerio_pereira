package br.com.jogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do arquivo e tecle enter");
		System.out.println("");
		String arquivo = sc.nextLine();
		
		
		
		List<String> linhasList = new LeitorArquivo().leitor(arquivo);
		
		Partida partida = new PartidaBean(linhasList);
		
		partida.carregarJogadores();
		
		
		
		partida.imprimirResultado();
	

	}

	
	
	

	

	

}

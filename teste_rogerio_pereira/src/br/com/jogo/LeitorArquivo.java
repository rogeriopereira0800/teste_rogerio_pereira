package br.com.jogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeitorArquivo implements Leitor {
	
	protected static final String DEFAULT_LINE_END = System.getProperty("line.separator");
	/* (non-Javadoc)
	 * @see br.com.jogo.Leitor#leitor(java.lang.String)
	 */
	@Override
	public List<String> leitor(String arquivo)  {
		Scanner sc;
		List<String> linhasList = new LinkedList<String>();
		try {
			sc = new Scanner(new FileReader(arquivo)).useDelimiter(DEFAULT_LINE_END);
			while(sc.hasNext()){
				String linha = sc.next();
				linhasList.add(linha);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
		
		
		return linhasList;
	}
	

}

package br.com.jogo;

import java.io.FileNotFoundException;
import java.util.List;

public interface Leitor {

	List<String> leitor(String arquivo) throws FileNotFoundException;

}
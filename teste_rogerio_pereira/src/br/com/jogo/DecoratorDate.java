package br.com.jogo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DecoratorDate {
	
	public static Calendar getCalendar(String[] inicioPartida) {
		Calendar calendar =Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date inicio;
		try {
			inicio = sdf.parse(inicioPartida[0]+" "+inicioPartida[1]);
			calendar.setTime(inicio);
		} catch (ParseException e) {
			System.out.println("Ocorreu um erro na conversação de data");
		}
		
		return calendar;
	}
	
	public static String formataData(Calendar calendar) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String 	data = sdf.format(calendar.getTime());
		
		return data;
	}

}

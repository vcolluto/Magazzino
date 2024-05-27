package org.generation.italy.model;

import java.time.LocalDate;

public class Movimento {
	public int id;
	public LocalDate data;
	public String codiceProdotto, codiceMovimento, riferimento;
	public int quantità;
	
	@Override
	public String toString() {
		return "Movimento {id=" + id + ", data=" + data + ", codiceProdotto=" + codiceProdotto + ", codiceMovimento="
				+ codiceMovimento + ", riferimento=" + riferimento + ", quantità=" + quantità + "}";
	}
	

}

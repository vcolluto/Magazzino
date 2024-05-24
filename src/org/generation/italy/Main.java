package org.generation.italy;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> elencoFornitori= new HashMap<String, String>(){{		
			put("F01","Mario Rossi");
			put("F02","Franco Verdi");
			put("F03","Gino Gialli");			
		}};
		
		HashMap<String, String> elencoClienti= new HashMap<String, String>(){{		
			put("C01","Franca Rame");
			put("C02","Pina Acciaio");
			put("C03","Lina Bronzo");			
		}};
		
		HashMap<String, String> elencoProdotti= new HashMap<String, String>(){{		
			put("P01","Pane");
			put("P02","Pasta");
			put("P03","Biscotti al cioccolato");			
		}};
		
		HashMap<String, String> tipologieMovimento= new HashMap<String, String>(){{		
			//movimenti in entrata
			put("E01","acquisto da fornitore");
			put("E02","reso da cliente");
			put("E03","produzione interna");			
			put("E04","spostamento da altro magazzino");
			
			//movimenti in uscita
			put("U01","vendita a cliente");
			put("U02","reso a fornitore");
			put("U03","sostituzione in garanzia");			
			put("U04","spostamento a altro magazzino");
		}};

	}

}

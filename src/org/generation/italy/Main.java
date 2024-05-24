package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.generation.italy.model.Movimento;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> elencoFornitori = new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put("F01", "Mario Rossi");
				put("F02", "Franco Verdi");
				put("F03", "Gino Gialli");
			}
		};

		HashMap<String, String> elencoClienti = new HashMap<String, String>() {			
			private static final long serialVersionUID = 1L;

			{
				put("C01", "Franca Rame");
				put("C02", "Pina Acciaio");
				put("C03", "Lina Bronzo");
			}
		};

		HashMap<String, String> elencoProdotti = new HashMap<String, String>() {			
			private static final long serialVersionUID = 1L;

			{
				put("P01", "Pane");
				put("P02", "Pasta");
				put("P03", "Biscotti al cioccolato");
			}
		};

		HashMap<String, String> tipologieMovimento = new HashMap<String, String>() {			
			private static final long serialVersionUID = 1L;

			{
				// movimenti in entrata
				put("E01", "acquisto da fornitore");
				put("E02", "reso da cliente");
				put("E03", "produzione interna");
				put("E04", "spostamento da altro magazzino");

				// movimenti in uscita
				put("U01", "vendita a cliente");
				put("U02", "reso a fornitore");
				put("U03", "sostituzione in garanzia");
				put("U04", "spostamento a altro magazzino");
			}
		};
		
		ArrayList<Movimento> elencoMovimenti =new ArrayList<Movimento>();

		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");		//uso il formato giorno/mese/anno
		Scanner sc = new Scanner(System.in);
		String scelta;
		Movimento m;
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n**** GESTIONE MAGAZZINO *****\n");
			System.out.println("1. Inserimento movimento in entrata");
			System.out.println("2. Inserimento movimento in uscita");
			System.out.println("3. Visualizzazione movimento in entrata");
			System.out.println("4. Visualizzazione movimento in uscita");
			System.out.println("5. Calcolo giacenza prodotto\n");
			System.out.println("6. Esci");

			System.out.print("\n\nInserisci la tua scelta: ");
			scelta = sc.nextLine();

			/*
			 * PRIMA possibilità: if/else if
			 * 
			 * if (scelta.equals("1")) {
			 * 
			 * } else if (scelta.equals("2")) {
			 * 
			 * } else if (scelta.equals("3")) {
			 * 
			 * } // ecc. ecc.
			 */

			switch (scelta) {
			case "1":
				// codice per il caso "1"
				System.out.println("Inserimento movimento in entrata");
				
				m=new Movimento();	//creo un nuovo oggetto Movimento
				System.out.print("Inserisci la data: ");
				m.data=LocalDate.parse(sc.nextLine(), df);	//leggo una stringa (sc.nextLine) e la converto in una data (LocalDate.parse) 	
				
				m.codiceProdotto= verificaCodice(elencoProdotti, sc, "Inserisci il codice prodotto: ");	//se il codice è valido, lo restituisce come valore di ritorno		
				
				System.out.print("Inserisci la quantità: ");
				m.quantità=sc.nextInt();
				sc.nextLine();
				
				m.codiceMovimento= verificaCodice(tipologieMovimento, sc, "Inserisci il codice movimento: ");
				
				/*
				do {
					System.out.print("Inserisci il codice movimento: ");
					m.codiceMovimento=sc.nextLine();
					if (!tipologieMovimento.containsKey(m.codiceMovimento) || 
						!m.codiceMovimento.startsWith("E"))  	//il codice movimento non è valido se non è contenuto nelle chiavi oppure se non inizia per "E"
						System.out.println("Codice movimento non valido");
				} while (!tipologieMovimento.containsKey(m.codiceMovimento) || 
						!m.codiceMovimento.startsWith("E"));
						
				System.out.println(tipologieMovimento.get(m.codiceMovimento));	//mostro il movimento selezionato
				
						
				*/
				
				if (m.codiceMovimento.equals("E01")) {				
					
					m.riferimento= verificaCodice(elencoFornitori, sc, "Inserisci il codice fornitore: ");
				} else if (m.codiceMovimento.equals("E02")) {					
					
					m.riferimento= verificaCodice(elencoClienti, sc, "Inserisci il codice cliente: ");
				}
				elencoMovimenti.add(m);	
				
				
				break;
			case "2":
				// codice per il caso "2"
				System.out.println("Inserimento movimento in uscita");
				break;
			case "3":
				System.out.println("Visualizzazione movimenti in entrata");
				// codice per il caso "3"
				break;
			case "4":
				// codice per il caso "4"
				System.out.println("Visualizzazione movimenti in uscita");
				break;
			case "5":
				// codice per il caso "5"
				System.out.println("Calcolo giacenza");
				break;
			case "6":
				// codice per il caso "6"
				System.out.println("Arrivederci!");
				break;
			default: // tutti gli altri casi verranno gestiti qui
				// codice per gestire tutti gli altri casi
				System.out.println("Scelta non valida!");
			}
			System.out.println("Premi invio per continuare...");
			sc.nextLine();
		} while (!scelta.equals("6")); // torno indietro se la scelta è diversa da 6
	sc.close();
	}

	
	//dato un generico hashmap codice-descrizione, verifica se il codice inserito dall'utente esiste nell'hashmap
	//se non esiste ripete l'inserimento, se esiste mostra la corrispondente descrizione
	private static String verificaCodice(HashMap<String, String> elencoValori, Scanner sc, String messaggio) {
		String codice;
		do {
			System.out.print(messaggio);
			codice=sc.nextLine();
			if (!elencoValori.containsKey(codice))
				System.out.println("Codice non valido");
		} while (!elencoValori.containsKey(codice)); //torno indietro se la chiave non esiste nell'hasmap 
		System.out.println("Hai selezionato: "+elencoValori.get(codice));
		return codice;		//dopo aver eseguito le istruzioni restituisco il valore del codice
	}

}

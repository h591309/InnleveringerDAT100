package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		String linje;
		int linjeNr = 1;
		
		File fil = new File(mappe + filnavn);
		Blogg resultat = null;
		
		Bilde nyttBilde;
		Tekst nyTekst;
		
		int id = 0;
		String bruker = "";
		String dato = "";
		int likes = 0;
		String tekst = "";
		String url = "";
		
		
		
		
		Scanner leser = null;
		
		try {
			leser = new Scanner(fil);
			
			while(leser.hasNextLine()) {
				
				nyttBilde = null;
				nyTekst = null;
				
				linje = leser.nextLine();
				
				if(linjeNr == 1) {
					resultat = new Blogg(Integer.parseInt(linje));	
				}
				
				System.out.println(linjeNr + " - " + linje);
				
				if(linje.equals(BILDE)) {
					for(int i = 0; i < 6; i++) {
						linje = leser.nextLine();
						switch(i) {
						case 0:
							id = Integer.parseInt(linje);
							break;
						case 1:
							bruker = linje;
							break;
						case 2:
							dato = linje;
							break;
						case 3:
							likes = Integer.parseInt(linje);
							break;
						case 4:
							tekst = linje;
							break;
						case 5:
							url = linje;
							break;
						}
						linjeNr++;
					}
					nyttBilde = new Bilde(id, bruker, dato, likes, tekst, url);
					resultat.leggTil(nyttBilde);
					nyttBilde = null;
				} else if(linje.equals(TEKST)) {
					
					for(int i = 0; i < 5; i++) {
						linje = leser.nextLine();
						switch(i) {
						case 0:
							id = Integer.parseInt(linje);
							break;
						case 1:
							bruker = linje;
							break;
						case 2:
							dato = linje;
							break;
						case 3:
							likes = Integer.parseInt(linje);
							break;
						case 4:
							tekst = linje;
							break;
						}
						linjeNr++;
					}
					nyTekst = new Tekst(id, bruker, dato, likes, tekst);
					resultat.leggTil(nyTekst);
					nyTekst = null;
				}	
			
				linjeNr++;
				
				
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Filen ble ikke funnet.");
		} finally {
			leser.close();
		}
		
		return resultat;
		
	}
}

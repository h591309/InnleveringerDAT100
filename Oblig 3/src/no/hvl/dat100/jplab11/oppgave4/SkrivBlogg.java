package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		File fil = new File(mappe + filnavn);
		boolean ok = true;
		try {
			fw = new FileWriter(fil, false);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			
			pw.println(samling.toString());
			pw.flush();
			
			System.out.println("Fil laget");
			
		} catch(FileNotFoundException e) {
			
			System.out.println("Fil ikke funnet!");
			ok = false;
			
		} catch(IOException e) {
			System.out.println("IOException");
			
		} finally {
			
			try {
				pw.close();
				fw.close();
				bw.close();
			} catch(IOException e) {
				System.out.print("Feilet.");
			}
			
		}
		
		return ok;
		
		//throw new UnsupportedOperationException(TODO.method());
	}
}

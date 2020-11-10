package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos = 0;
		boolean funnet = false;
		
		while(pos < nesteledig && !funnet) {
			
			if(innleggtabell[pos].erLik(innlegg))
				funnet = true;
			
			if(!funnet)
				pos++;
		}
		if(funnet)
			return pos;
		
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		System.out.print(innlegg);
		if(finnInnlegg(innlegg) >= 0)
			return true;

		return false;
	}

	public boolean ledigPlass() {
		if(nesteledig < innleggtabell.length-1)
			return true;
		else 
			return false;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
			
	}
	
	public String toString() {
		String str = getAntall() + "\n";

		for(int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] != null)
			str += innleggtabell[i].toString();
		}
		
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] tempTab = new Innlegg[innleggtabell.length * 2];
		
		for(int i = 0; i < innleggtabell.length; i++) {
			
			tempTab[i] = innleggtabell[i];
			
		}
		
		innleggtabell = new Innlegg[tempTab.length];
		
		for(int i = 0; i < innleggtabell.length; i++) {
			innleggtabell[i] = tempTab[i];
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		boolean lagtTil = false;
		
		if(!finnes(innlegg)) {
			if(nesteledig >= innleggtabell.length - 1)
				utvid();
			
			leggTil(innlegg);
			lagtTil = true;
		}
			
		return lagtTil;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		boolean slettet = false;
		
		if(pos >= 0) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			slettet = true;
		}
	
		return slettet;
	}
	
	public int[] search(String keyword) {
		
		int[] resultat = new int[innleggtabell.length];
		for(int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i].toString().contains(keyword))
				resultat[i] = innleggtabell[i].getId();
		}
		
		return resultat;
		
		//throw new UnsupportedOperationException(TODO.method());

	}
}
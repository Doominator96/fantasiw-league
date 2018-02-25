package utility;

import java.util.Comparator;

import model.Giocatore;
import model.RosaUtente;

public class GiocatoriComparator {
	 public static Comparator<Giocatore> COMPARATOR = new Comparator<Giocatore>()
	    {
	    // This is where the sorting happens.
		 public int compare(Giocatore g1, Giocatore g2)
		    {
			 return g1.getRuolo().compareTo(g2.getRuolo());
		    }
	   
};
}

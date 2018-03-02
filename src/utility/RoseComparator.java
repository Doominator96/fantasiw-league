package utility;

import java.util.Comparator;

import model.RosaUtente;

public class RoseComparator {
	 public static Comparator<RosaUtente> COMPARATOR = new Comparator<RosaUtente>()
	    {
	    // This is where the sorting happens.
		 public int compare(RosaUtente r1, RosaUtente r2)
		    {
		        float differenzaPunti = r1.getPunteggio() - r2.getPunteggio();
		        if (differenzaPunti == 0) {
		        		return r1.getGolFatti() - r2.getGolFatti();  	
		        }
		        else
		        	return (int)differenzaPunti;
		    }
	    };
}

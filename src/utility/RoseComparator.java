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
		        	int differenzaVittorie=r1.getVittorie() - r2.getVittorie();
		        	if (differenzaVittorie == 0) {
		        		int differenzaGol=r1.getGolFatti() - r2.getGolFatti();
		        	if (differenzaGol == 0) {
		        			return r1.getPareggi() - r2.getPareggi();
		        		}
		        		return differenzaGol;
		        	}
		        	return differenzaVittorie; 
		        }
		        else
		        return (int)differenzaPunti;
		    }
	    };
}

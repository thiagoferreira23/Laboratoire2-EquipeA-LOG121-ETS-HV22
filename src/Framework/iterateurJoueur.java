package Framework;

import java.util.Arrays;
import java.util.Iterator;

public class iterateurJoueur implements Iterator<Joueur> {
    private Iterator<Joueur> lstJoueur;

    public iterateurJoueur(Joueur[] nvlstJoueur){
        lstJoueur = Arrays.stream(nvlstJoueur).iterator();
    }

    @Override
    public boolean hasNext() {
        while (lstJoueur.hasNext()){
            return true;
        }
        return false;
    }

    @Override
    public Joueur next() {
        return lstJoueur.next();
    }

    public int size()  {
        int i = 0;
        while (hasNext()) {
            this.next();
            i++;
        }
        return i;
    }

}

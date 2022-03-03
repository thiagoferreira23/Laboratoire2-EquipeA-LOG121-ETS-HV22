package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class De implements Comparable {

    private int nbFacesDe;
    private int [] aDe;

    public De(int nbFacesDe) {
        this.nbFacesDe = nbFacesDe;
        this.aDe = new int[nbFacesDe+1];
        remplissageDe(aDe);
    }

    private void remplissageDe(int [] tab){
        for(int i = 1 ; i < tab.length; i++){

            tab[i]+=i;

        }
    }

    public void affichageTab(){

        for(int i = 1 ; i < this.aDe.length; i++){
            System.out.println(this.aDe[i]);
        }
    }



}

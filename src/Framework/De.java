package Framework;

import java.util.Random;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class De implements Comparable<De> {
    private int nbFaceDe;
    private int faceJouer;
    private int [] aDe;

    public De(int nbFacesDe) {
        this.nbFaceDe = nbFacesDe;
        this.aDe = new int[nbFacesDe+1];
        remplissageDe(aDe);
    }
    private void remplissageDe(int [] tab){
        for(int i = 1 ; i < tab.length; i++){
            tab[i]+=i;
        }
    }
    public boolean affichageTab(){
        for(int i = 1 ; i < this.aDe.length; i++){
            System.out.println(this.aDe[i]);
        }
        return false;
    }

    //METHODES
    @Override
    public int compareTo(De de) {
        if (this.nbFaceDe == de.getNbFacesDe()){
            return 0;
        }
        else if (this.nbFaceDe > de.nbFaceDe){
            return 1;
        }
        else {
            return -1;
        }
    }

    public void roulerDe() {
        Random rnd = new Random();
        this.faceJouer = rnd.nextInt(this.nbFaceDe) + 1;
    }

    //GETTER ET SETTER
    public int getNbFacesDe() {
        return nbFaceDe;
    }

    public void setNbFacesDe(int nbFacesDe) {
        this.nbFaceDe = nbFacesDe;
    }

    public int getFaceJouer() {
        return faceJouer;
    }

    public void setFaceJouer(int faceJouer) {
        this.faceJouer = faceJouer;
    }

    public int[] getaDe() {
        return aDe;
    }

    public void setaDe(int[] aDe) {
        this.aDe = aDe;
    }
}

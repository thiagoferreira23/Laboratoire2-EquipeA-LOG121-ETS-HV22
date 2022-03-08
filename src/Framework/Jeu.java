package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class Jeu {

    private CollectionJoueur<Joueur> lstJoueurEnJeu;
    private CollectionDe<De> lstDeEnJeu;
    private iterateurJoueur iteJoueur;
    private iterateurDe iteDe;
    private int numTour = 0;
    private int nbTour = 0;

    public Jeu (int nbTourPourJeu){
        this.nbTour = nbTourPourJeu;
    }

    //METHODES
    public void calculerScoreTour(){
        //APPELLE UN TYPE DE ISTRATEGIE
    }
    public void calculerLeVainqueur(){

    }

    //GETTER ET SETTER
    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public CollectionJoueur<Joueur> getLstJoueurEnJeu() {
        return lstJoueurEnJeu;
    }

    public void setLstJoueurEnJeu(CollectionJoueur<Joueur> lstJoueurEnJeu) {
        this.lstJoueurEnJeu = lstJoueurEnJeu;
    }

    public CollectionDe<De> getLstDeEnJeu() {
        return lstDeEnJeu;
    }

    public void setLstDeEnJeu(CollectionDe<De> lstDeEnJeu) {
        this.lstDeEnJeu = lstDeEnJeu;
    }

    public iterateurDe getIteDe() {
        iteDe = lstDeEnJeu.creerIterateur();
        return iteDe;
    }

    public iterateurJoueur getIteJoueur() {
        iteJoueur = lstJoueurEnJeu.creerIterateur();
        return iteJoueur;
    }
}

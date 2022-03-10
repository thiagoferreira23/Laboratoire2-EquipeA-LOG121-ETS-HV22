package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public abstract class Jeu {

    private CollectionJoueur<Joueur> lstJoueurEnJeu;
    private CollectionDe<De> lstDeEnJeu;
    private IStrategie typeStrategieCalcul;
    private int numTour = 0;
    private int nbTour;

    private int pointageParTour; //Pointage par tour

    public Jeu (int nbTourPourJeu, int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie typeStrategieCalcul){
        initialiserJeu(nbTourPourJeu, nbDeJoueur, nbFaceDe, nbDeParJoueur, typeStrategieCalcul);
    }

    //METHODES
    public void initialiserJeu(int nbTourPourJeu,int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie typeStrategieCalcul){
        creerJoueur(nbDeJoueur);
        creerDe(nbFaceDe, nbDeParJoueur);
        setNbTour(nbTourPourJeu);
        setTypeStrategieCalcul(typeStrategieCalcul);
    };

    public void creerJoueur(int nbDeJoueur) {
        CollectionJoueur<Joueur> lstNvJoueur = new CollectionJoueur<Joueur>(nbDeJoueur);
        for (int i = 0; i < nbDeJoueur; i++){
            lstNvJoueur.ajouterJoueur(new Joueur ("J"+(i+1), (i+1), 0, true));
        }
        this.lstJoueurEnJeu = lstNvJoueur;
    }
    public void creerDe(int nbFaceDe, int nbDeParJoueur) {
        CollectionDe<De> lstNvDe =  new CollectionDe<De>(nbDeParJoueur);
        for (int i = 0; i < nbDeParJoueur; i++){
            lstNvDe.ajouterDe(new De (nbFaceDe));
        }
        this.setLstDeEnJeu(lstNvDe);
    }

    public abstract void calculerScoreTour();
    public abstract void calculerLeVainqueur();
    public abstract void jouer();

    public void incrementerTour(){
        this.numTour++;
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

    public CollectionDe<De> getLstDeEnJeu() {
        return lstDeEnJeu;
    }

    public void setLstDeEnJeu(CollectionDe<De> lstDeEnJeu) {
        this.lstDeEnJeu = lstDeEnJeu;
    }

    public IStrategie getTypeStrategieCalcul() {
        return typeStrategieCalcul;
    }

    public void setTypeStrategieCalcul(IStrategie typeStrategieCalcul) {
        this.typeStrategieCalcul = typeStrategieCalcul;
    }

    public int getPointageParTour() {
        return pointageParTour;
    }

    public void setPointageParTour(int pointageParTour) {
        this.pointageParTour = pointageParTour;
    }
}

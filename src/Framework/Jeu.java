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
  
    /**
     <p>Cette méthode est le constructeur par défaut de la classe Jeu. Elle
     * permet d'initialiser les variables de cette classe avec leurs paramètres
     * défini.</p>
     *
     * @param nbTourPourJeu Le nombre de tours dans le jeu
     * @param nbDeJoueur Le nombre de joueurs dans le jeu
     * @param nbFaceDe Le nombre de face du dé dans le jeu
     * @param nbDeParJoueur Le nombre de dés par joueur dans le jeu
     * @param typeStrategieCalcul Le type de stratégie dans le jeu
     */
    public Jeu (int nbTourPourJeu, int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie typeStrategieCalcul){
        creerJoueur(nbDeJoueur);
        creerDe(nbFaceDe, nbDeParJoueur);
        setNbTour(nbTourPourJeu);
        setTypeStrategieCalcul(typeStrategieCalcul);
    }

    //METHODES

    /**
     * <p></p>
     * @param nbDeJoueur
     */
    public void creerJoueur(int nbDeJoueur) {
        CollectionJoueur<Joueur> lstNvJoueur = new CollectionJoueur<Joueur>(nbDeJoueur);
        for (int i = 0; i < nbDeJoueur; i++){
            lstNvJoueur.ajouterJoueur(new Joueur ("J"+(i+1), (i+1), 0, true));
        }
        this.lstJoueurEnJeu = lstNvJoueur;
    }

    /**
     * <p></p>
     * @param nbFaceDe
     * @param nbDeParJoueur
     */
    public void creerDe(int nbFaceDe, int nbDeParJoueur) {
        CollectionDe<De> lstNvDe =  new CollectionDe<De>(nbDeParJoueur);
        for (int i = 0; i < nbDeParJoueur; i++){
            lstNvDe.ajouterDe(new De (nbFaceDe));
        }
        this.setLstDeEnJeu(lstNvDe);
    }


    /**
     * <p></p>
     */
    public abstract void calculerScoreTour();

    /**
     * <p></p>
     */
    public abstract void calculerLeVainqueur();

    /**
     * <p></p>
     */
    public abstract void jouer();

    /**
     * <p></p>
     */
    public void incrementerTour(){
        this.numTour++;
    }


    //GETTER AND SETTER
    /**
     * <p></p>
     * @return
     */
    public int getNbTour() {
        return nbTour;
    }

    /**
     * <p></p>
     * @param nbTour
     */
    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    /**
     * <p></p>
     * @return
     */
    public int getNumTour() {
        return numTour;
    }

    /**
     * <p></p>
     * @param numTour
     */
    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    /**
     * <p></p>
     * @return
     */
    public CollectionJoueur<Joueur> getLstJoueurEnJeu() {
        return lstJoueurEnJeu;
    }

    /**
     * <p></p>
     * @return
     */
    public CollectionDe<De> getLstDeEnJeu() {
        return lstDeEnJeu;
    }

    /**
     * <p></p>
     * @param lstDeEnJeu
     */
    public void setLstDeEnJeu(CollectionDe<De> lstDeEnJeu) {
        this.lstDeEnJeu = lstDeEnJeu;
    }

    /**
     * <p></p>
     * @return
     */
    public IStrategie getTypeStrategieCalcul() {
        return typeStrategieCalcul;
    }

    /**
     * <p></p>
     * @param typeStrategieCalcul
     */
    public void setTypeStrategieCalcul(IStrategie typeStrategieCalcul) {
        this.typeStrategieCalcul = typeStrategieCalcul;
    }
}

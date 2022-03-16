package Framework;

/**
 * <p>Cette classe représente une collection de joueur. Elle possède une liste
 * de tous les joueurs faisant partie d’un jeu de dé. De plus, elle permet de
 * créer l’itérateur correspondante afin de pouvoir parcourir sa propre liste de
 * type Collection.</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:20 a.m.
 */
public class CollectionJoueur<T> {
    private Joueur[] lstJoueur; //Une liste d'objet Joueur
    private iterateurJoueur iteJoueur; //L'itérateur d'un Joueur spécifique

    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe. Elle
     * permet de configurer les paramètres de cette classe avec les paramètres
     * qu'elle reçoit en paramètre.</p>
     *
     * @param lstJoueurCapacite Ce paramètre défini la taille
     *                          du tableau de Joueur
     */
    public CollectionJoueur(int lstJoueurCapacite) {
        lstJoueur = new Joueur[lstJoueurCapacite];
    }

    /**
     * <p>Cette méthode permet d'ajouter un Joueur à la liste de Joueur
     * de cette classe</p>
     *
     * @param joueur Un joueur du jeu avec ses paramètres unique
     */
    public void ajouterJoueur(Joueur joueur) {
        for (int i = 0; i < lstJoueur.length; i++) {
            if (lstJoueur[i] == null) {
                lstJoueur[i] = joueur;
                break;
            }
            if (lstJoueur[lstJoueur.length - 1] != null) {
                break;
            }
        }
    }

    /**
     * <p>Cette méthode permet de créer un itérateur pour un Joueur.</p>
     *
     * @return iteJoueur - L'itérateur d'un Joueur spécifique
     */
    public iterateurJoueur creerIterateur() {
        iteJoueur = new iterateurJoueur(lstJoueur);
        return iteJoueur;
    }

    /**
     * <p>Ce getter retourne la liste d'objet Joueur</p>
     *
     * @return La liste d'objet Joueur
     */
    public Joueur[] getLstJoueur() {
        return lstJoueur;
    }

    /**
     * <p>Ce setter permet de recevoir en paramètre une liste contenant des
     * objets Joueur et de l'enregistrer dans la variable locale
     * de cette classe.</p>
     *
     * @param lstJoueur - Une liste d'objet Dé
     */
    public void setLstJoueur(Joueur[] lstJoueur) {
        this.lstJoueur = lstJoueur;
    }

}

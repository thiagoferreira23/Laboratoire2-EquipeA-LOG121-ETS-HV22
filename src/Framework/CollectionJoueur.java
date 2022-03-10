package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:20 a.m.
 */
public class CollectionJoueur<T> {
    private Joueur[] lstJoueur;

    public CollectionJoueur(int lstJoueurCapacite){
        lstJoueur = new Joueur[lstJoueurCapacite];
    }

    public void ajouterJoueur(Joueur joueur){
        for (int i = 0; i < lstJoueur.length; i++){
            if (lstJoueur[i] == null){
                lstJoueur[i] = joueur;
                break;
            }
            if (lstJoueur[lstJoueur.length-1] != null){
                break;
            }
        }
    }

    public iterateurJoueur creerIterateur(){
        iterateurJoueur iteJoueur = new iterateurJoueur(lstJoueur);
        return iteJoueur;
    }
}

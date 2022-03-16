package Framework;


/**
 * <p>Cette classe représente une collection de dés. Elle possède une liste qui
 * contient tous les dés composant un type de jeu de dé. De plus, elle permet
 * de créer l’itérateur correspondante afin de pouvoir parcourir sa propre liste
 * de type Collection.</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class CollectionDe<T> {
    private De[] lstDe; //Une liste d'objet Dé
    private iterateurDe iteDe; //L'itérateur d'un Dé

    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe. Elle
     * permet de configurer les paramètres de cette classe avec les paramètres
     * qu'elle reçoit en paramètre.</p>
     *
     * @param lstDeCapacite ***
     */
    public CollectionDe(int lstDeCapacite) {
        lstDe = new De[lstDeCapacite];
    }

    /**
     * <p>Cette méthode permet d'ajouter un dé à la liste de Dé
     * de cette classe</p>
     *
     * @param de Un dé du jeu avec ses paramètres unique
     */
    public void ajouterDe(De de) {
        for (int i = 0; i < lstDe.length; i++) {
            if (lstDe[i] == null) {
                lstDe[i] = de;
                break;
            }
            if (lstDe[lstDe.length - 1] != null) {
                break;
            }
        }
    }

    /**
     * <p>Cette méthode permet de créer un itérateur pour un Dé.</p>
     *
     * @return iteDe – L'itérateur d'un Dé spécifique
     */
    public iterateurDe creerIterateur() {
        iteDe = new iterateurDe(lstDe);
        return iteDe;
    }
}

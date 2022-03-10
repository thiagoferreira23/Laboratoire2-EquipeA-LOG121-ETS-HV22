package Framework;


/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class CollectionDe<T extends Comparable>{
    private De[] lstDe;
    private iterateurDe iteDe;

    public CollectionDe(int lstDeCapacite){
        lstDe = new De[lstDeCapacite];
    }

    public void ajouterDe(De de){
        for (int i = 0; i < lstDe.length; i++){
            if (lstDe[i] == null){
                lstDe[i] = de;
                break;
            }
            if (lstDe[lstDe.length-1] != null){
                break;
            }
        }
    }

    public iterateurDe creerIterateur(){
        iteDe = new iterateurDe(lstDe);
        return iteDe;
    }
}

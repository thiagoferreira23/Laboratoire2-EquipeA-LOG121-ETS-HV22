package Framework;

import java.util.Random;

/**
 * <p>Cette classe permet d’initialiser le dé selon les paramètres qu’on lui
 * donne. Selon le nombre de faces donnés, un tableau de dé est rempli.
 * Ensuite, nous avons différentes méthodes qui permettent de comparer et de
 * rouler le dé.</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class De implements Comparable {
    private int nbFaceDe; //Le nombre de face qu'un Dé peu avoir
    private int faceJouer; //TODO
    private int[] aDe; //Tableau contenant le nombre de face qu'un Dé peu avoir

    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe.
     * Elle permet de configurer les paramètres de cette classe avec les
     * paramètres qu'elle reçoit en paramètre.</p>
     */
    public De() {
        this.nbFaceDe = 0;
        this.aDe = new int[0];
    }

    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe.
     * Elle permet de configurer les paramètres de cette classe avec les
     * paramètres qu'elle reçoit en paramètre.</p>
     *
     * @param nbFacesDe Le nombre de face qu'un Dé peu avoir
     */
    public De(int nbFacesDe) {
        this.nbFaceDe = nbFacesDe;
        this.aDe = new int[nbFacesDe + 1];
        remplissageDe(aDe);
    }

    /**
     * <p>Cette classe permet de remplir le tableau qui contiendra les faces du
     * Dé. Exemple, un Dé à 6 faces alors le tableau à 6 entrés.</p>
     *
     * @param tab Tableau contenant le nombre de face qu'un Dé peu avoir
     */
    public void remplissageDe(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            tab[i] += i;
        }
    }

    /**
     * <p>
     * TODO
     * </p>
     *
     * @return Un boolean par défaut configurer à false.
     */
    public boolean affichageTab() {
        for (int i = 1; i < this.aDe.length; i++) {
            System.out.println(this.aDe[i]);
        }
        return false;
    }

    /**
     * <p>Cette méthode permet de faire rouleur le Dé pour arriver
     * sur une des faces du Dé en utilisant un méthode qui choisi aléatoirement
     * cette face.</p>
     *
     * @return La face choisie aléatoirement
     */
    public int roulerDe() {
        Random rnd = new Random();
        this.faceJouer = rnd.nextInt(this.nbFaceDe) + 1;
        return this.faceJouer;
    }

    /**
     * <p>Cette méthode retourne le nombre de face d'un Dé</p>
     *
     * @return Le nombre de face d'un Dé
     */
    public int getNbFacesDe() {
        return nbFaceDe;
    }

    /**
     * <p>Cette méthode permet de recevoir en paramètre un nombre (int) de faces
     * d'un Dé et de l'enregistrer dans la variable locale de cette classe.</p>
     *
     * @param nbFacesDe Un nombre de face d'un Dé
     */
    public void setNbFacesDe(int nbFacesDe) {
        this.nbFaceDe = nbFacesDe;
    }

    /**
     * <p>Cette méthode retourne la face choisie aléatoirement par la méthode
     * roulerDe()</p>
     *
     * @return
     */
    public int getFaceJouer() {
        return faceJouer;
    }

    /**
     * <p>Cette méthode permet de recevoir en paramètre un nombre (int) qui sera
     * traduit comme la face choisie. Cette valeur sera enregistrer localement
     * dans cette classe.</p>
     *
     * @param faceJouer
     */
    public void setFaceJouer(int faceJouer) {
        this.faceJouer = faceJouer;
    }

    /**
     * <p>Cette méthode retourne le tableau contenant les faces d'un Dé.</p>>
     *
     * @return Un tableau contenant les faces d'un Dé
     */
    public int[] getaDe() {
        return aDe;
    }

    /**
     * <p>Cette méthode permet de recevoir en paramètre un tableau contenant les
     * faces d'un Dé. Ce tableau sera enregistrer localement dans
     * cette classe.</p>
     *
     * @param aDe Un tableau contenant les faces d'un Dé
     */
    public void setaDe(int[] aDe) {
        this.aDe = aDe;
    }

    /**
     * <p>
     * Compare les dés jouées
     * </p>
     *
     * @param o : Objet de type o, où o est un objet de type Dé
     * @return chiffre correspond
     */
    public int compareTo(Object o) {

        if (this.getFaceJouer() == ((De) o).getFaceJouer()) {
            return 0;
        } else if (this.getFaceJouer() > ((De) o).getFaceJouer()) {
            return 1;
        } else {
            return -1;
        }
    }
}

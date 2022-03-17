package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class Joueur implements Comparable{

    private String nomComplet;
    private int idJoueur;
    private int points;
    private Boolean status;
    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe.
     * Elle permet de configurer les paramètres de cette classe avec les
     * paramètres qu'elle reçoit en paramètre.</p>
     */
    public Joueur() {
        this.nomComplet = "";
        this.idJoueur = 0;
        this.points = 0;
        this.status = false;
    }
    /**
     * <p>Cette méthode est le constructeur par défaut de cette classe.
     * Elle permet de configurer les paramètres de cette classe avec les
     * paramètres qu'elle reçoit en paramètre.</p>
     *
     * @param nomComplet,id,points,status
     */
    public Joueur(String nomComplet, int idJoueur, int points, Boolean status) {
        this.nomComplet = nomComplet;
        this.idJoueur = idJoueur;
        this.points = points;
        this.status = status;
    }


    //GETTER AND SETTER
    /**
     * <p>Cette méthode redéfini le toString de la methode object
     * </p>
     *
     * @return
     */
    @Override
    public String toString() {
        return nomComplet +", le Joueur " + idJoueur + " a obtenu " + points +" points";
    }
    /**
     * <p>Cette méthode retourne le nom complet du joueur
     * </p>
     *
     * @return
     */
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    /**
     * <p>Cette méthode retourne le id du joueur
     * </p>
     *
     * @return
     */
    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }
    /**
     * <p>Cette méthode retourne les points du joueur
     * </p>
     *
     * @return
     */
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    /**
     * <p>Cette méthode retourne le status du joueur
     * </p>
     *
     * @return
     */
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //METHODES
    /**
     * <p>Cette méthode ajoute des points
     * </p>
     *
     * @return
     */
    public void ajouterPoints (int points) { this.setPoints(this.getPoints() + points); }

    /**
     * <p>Cette méthode compare les points avec les joueurs
     * </p>
     *
     * @return
     */
    public int compareTo(Object o) {
        //METHODES
        if (this.getPoints() == ((Joueur)o).getPoints()){
            return 0;
        }
        else if (this.getPoints() > ((Joueur)o).getPoints()){
            return 1;
        }
        else {
            return -1;
        }

    }
}

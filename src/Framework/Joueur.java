package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public class Joueur implements Comparable<Joueur>{

    private String nomComplet;
    private int idJoueur;
    private int points;
    private Boolean status;

    public Joueur() {
        this.nomComplet = "";
        this.idJoueur = 0;
        this.points = 0;
        this.status = false;
    }

    public Joueur(String nomComplet, int idJoueur, int points, Boolean status) {
        this.nomComplet = nomComplet;
        this.idJoueur = idJoueur;
        this.points = points;
        this.status = status;
    }

    //METHODES
    @Override
    public String toString() {
        return nomComplet +", le Joueur " + idJoueur + " a obtenu " + points +" points";
    }

    @Override
    public int compareTo(Joueur joueur) {
        if (this.points == joueur.getPoints()){
            return 0;
        }
        else if (this.points > joueur.getPoints()){
            return 1;
        }
        else {
            return -1;
        }
    }

    //GETTER ET SETTER
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}

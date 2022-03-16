package Framework;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public interface IStrategie {
    public CollectionJoueur calculerLeVainqueur(Jeu jeu);
    public boolean calculerScoreTour(Jeu jeu);

}

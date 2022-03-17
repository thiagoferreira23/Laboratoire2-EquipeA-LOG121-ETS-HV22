package Framework;

/**
 * <p>Cette classe est une classe abstraite qui sert de gabarit pour
 * toutes les stratégies de jeu qui peuvent être créées.</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:22 a.m.
 */
public interface IStrategie {
    public CollectionJoueur calculerLeVainqueur(Jeu jeu);

    public boolean calculerScoreTour(Jeu jeu);

}

package Framework;

import Bunco.BuncoPlus;

public class StrategieBuncoPlus implements IStrategie{
    @Override
    public void calculerLeVainqueur(Jeu jeu) {

    }

    @Override
    public void calculerScoreTour(Jeu jeu) {
        iterateurDe iteDe = jeu.getLstDeEnJeu().creerIterateur();
        int point = 0;
        while (iteDe.hasNext()){
            int chiffreJoue = iteDe.next().getFaceJouer();
            if (jeu.getNumTour()+1 == chiffreJoue){
                point++;
            }
            if (point == 3){
                point = 21;
            }

        }
        jeu.setPointageParTour(point);
    }
}

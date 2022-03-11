package Bunco;

import Bunco.BuncoPlus;
import Framework.IStrategie;
import Framework.Jeu;
import Framework.iterateurDe;

public class StrategieBuncoPlus implements IStrategie {
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
        }
        if (((BuncoPlus)jeu).tripleCombinaison() == true){
            point = 5;
        }
        if (((BuncoPlus)jeu).buncoCombinaison() == true){
            point = 21;
        }


        jeu.setPointageParTour(point);
    }
}

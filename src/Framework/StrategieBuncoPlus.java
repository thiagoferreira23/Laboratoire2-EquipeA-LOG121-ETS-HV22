package Framework;

import Bunco.BuncoPlus;

public class StrategieBuncoPlus implements IStrategie{
    @Override
    public void calculerLeVainqueur(Jeu jeu) {

    }

    @Override
    public void calculerScoreTour(Jeu jeu) {
        iterateurDe iteDe = jeu.getIteDe();
        int point = 0;
        while (iteDe.hasNext()){
            int chiffreJoue = iteDe.next().getFaceJouer();
            System.out.println(chiffreJoue);
            if (jeu.getNumTour()+1 == chiffreJoue){
                point++;
            }
            //CONDITION BUNCO SI POINTS = 3
        }
        System.out.println("POINTAGE : " + point);

    }
}

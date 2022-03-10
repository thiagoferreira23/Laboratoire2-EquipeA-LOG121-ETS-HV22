package Bunco;

import Framework.*;

import java.util.Random;

public class BuncoPlus extends TemplateJeuDe {
    private Jeu jeuBuncoPlus;

    @Override
    public void initialiserJeu(int nbJoueur, int nbDeParJoueur, int nbFaceDe, int nbTour, IStrategie regleJeu){
        jeuBuncoPlus = new Jeu(nbTour);
        this.creerJoueur(nbJoueur);
        this.creerDe(nbFaceDe, nbDeParJoueur);
    }

    @Override
    public void creerJoueur(int nbDeJoueur) {
        CollectionJoueur<Joueur> lstNvJoueur = new CollectionJoueur<Joueur>(nbDeJoueur);
        for (int i = 0; i < nbDeJoueur; i++){
            lstNvJoueur.ajouterJoueur(new Joueur ("J"+(i+1), (i+1), 0, true));
        }
        jeuBuncoPlus.setLstJoueurEnJeu(lstNvJoueur);
    }

    @Override
    public void creerDe(int nbFaceDe, int nbDeParJoueur) {
        CollectionDe<De> lstNvDe =  new CollectionDe<De>(nbDeParJoueur);
        for (int i = 0; i < nbDeParJoueur; i++){
            lstNvDe.ajouterDe(new De (nbFaceDe));
        }
        jeuBuncoPlus.setLstDeEnJeu(lstNvDe);
    }

    public void jouerUnTour(){
        //GET NOMBRE DE DICE PAR TOUR
        iterateurDe iteDe = jeuBuncoPlus.getIteDe();

        //DÉMARRER LA PARTIE
        System.out.println("Commencer la partie...");
        String demarrerJeu = sc.nextLine();

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        int pointage = 0;
        while (this.getNumTour() != this.getNbTour()) {
            //CRÉER TABLEAU POUR LES JOUEURS
            iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();

            //CRÉER TABLEAU POUR DÉS JOUÉS
            iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
            int[] lstValeurDeEnJeu = new int[iteDe.size()];

            //JOUEUR X JOUE UN TOUR
            while (iteJoueur.hasNext()) {
                Joueur joueur = iteJoueur.next();
                boolean pointGagne = true;
                while (pointGagne == true) {
                    pointGagne = false;

                    iteDe = this.getLstDeEnJeu().creerIterateur();
                    int index = 0;
                    while (iteDe.hasNext()) {
                        lstValeurDeEnJeu[index] = iteDe.next().roulerDe();
                        if (lstValeurDeEnJeu[index] == this.getNumTour() + 1) {
                            pointGagne = true;
                        }
                        index++;
                    }
                    calculerScoreTour();
                    joueur.setPoints(joueur.getPoints() + this.getPointageParTour());
                    afficherResultatParTour(this.getNumTour(), joueur.getIdJoueur(), lstValeurDeEnJeu, this.getPointageParTour());
                    if (pointGagne == true) {
                        System.out.println("Relancer de nouveau!");
                    }
                    else {
                        System.out.println("Prochain joueur!!");
                    }
                    String continuerJeu = sc.nextLine();
                }
            }
            this.incrementerTour();
            System.out.println("\n");
            System.out.println("Prochain tour...");
            String continuerJeu = sc.nextLine();
        }
        System.out.println("\n \n");
        afficherResultatFinal();
    }


    //METHODES POUR TESTER LES DONNES (PAS NECESSAIRE)
    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatParTour(int numTour, int idJoueur, int[] lstValeurDe, int pointage) {
        System.out.println("========================");
        System.out.println("        TOUR " + (numTour + 1));
        System.out.println("       JOUEUR " + idJoueur);
        System.out.print("======================== \n \n");
        System.out.print("DÉS JOUÉS : ");
        for (int i = 0; i < lstValeurDe.length; i++) {
            System.out.print(lstValeurDe[i] + " ");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("POINTS : " + pointage);
        System.out.println("---------------");
        System.out.println("\n");
    }

    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatFinal() {
        iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();
        System.out.println("=========================");
        System.out.println("         BUNCO+ ");
        System.out.println("    CLASSEMENT FINALE ");
        System.out.print  ("========================= \n \n");
        while (iteJoueur.hasNext()){
            Joueur joueur = iteJoueur.next();
            System.out.println(joueur.getNomComplet() + " : " + joueur.getPoints() + " POINTS");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("\n");
    }
}

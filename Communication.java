import java.util.*;

public class Communication{
    
    private Scanner sc = new Scanner(System.in);
    
    /***************************************************************************************************************************************/
    
    public Mouvement demanderMouvement(Plateau p){

	//Dans cette partie, on utilise des do ... while pour être sûre de ne pas sortir du tableau
	do{
	    System.out.println("\t Coordonnées de la case de départ : ");
	    System.out.println("Saisir l'ordonnée y1 de la case compris entre 0 et 7 \n"
			       "ou                      -10- pour quitter la partie");
	    
	    int y1 = sc.nextInt();
	    if(y1 == 10)
		quitter();
	}
	while(y1 < 0 || y1 > 7);
	do{
	    System.out.println("Saisir l'abscisse x1 de la case compris entre 0 et 7 \n"
			       "ou                      -10- pour quitter la partie\n");
	    int x1 = sc.nextInt();
	    if(x1 == 10)
		quitter();
	}
	while(x1 < 0 || x2 > 0);
	do{
	    System.out.println("\t Coordonnées de la case d'arrivée : ");
	    System.out.println("Saisir l'ordonnée y2 de la case compris entre 0 et 7 \n"
			       "ou                      -10- pour quitter la partie\n");
	    int y2 = sc.nextInt();
	    if(y2 == 10)
		quitter();
	}
	while(y2 < 0 || y2 > 7);
	do{
	    System.out.println("Saisir l'abscisse x2 de la case compris entre 0 et 7 \n"
			       "ou                      -10- pour quitter la partie\n");
	    int x2 = sc.nextInt();
	    if(x2 == 10)
		quitter();
	}
	while(x2 < 0 || x2 > 7);
	
	Mouvement res = new Mouvement(p.echiquier[y1][x1], p.echiquier[y2][x2]);
	
	return res;
	
    }

    /***************************************************************************************************************************************/
    
    private void quitter(){
	System.out.println("Vous avez decider de quitter la partie. Aurevoire\n\n");
	System.exit(0);
    }
    
}

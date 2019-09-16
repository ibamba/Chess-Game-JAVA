public class Jeu{

    private Communication saisie;
    private Plateau p;
    boolean joueur; //Joueur Blanc = true; Joueur Noir = false
    
    public Jeu(){
	
	this.p = new Plateau();
	p.initialisation();
	this.joueur = false;
	
    }
    
    /***************************************************************************************************************************************/
    
    public void changerJoueur(int i){
	
	if(i == 0)
	    joueur = true;
	else
	    joueur = false;
	
    }
    
    /**************************************************************************************************************************************/
    
    public void jouer(int n){
	
	int tour = 0;
	do{
	    System.out.println("Au tour du joueur " + tour);
	    saisie = new Communication();
	    do{
		Mouvement m = new Mouvement();
		m  = saisie.demanderMouvement(p);
	    }
	    while(!m.isValid(p, joueur));
	    p.deplace(m, joueur);
	    tour++;
	    tour = tour % 2;
	    changerJoueur(tour);
	    n--;
	}
	while(n > 0);
	
    }
    
    
}

public class Plateau{
    
    final static int longueur = 8, largeur = 8;
    private Case [][] echiquier;
    
    public Plateau(){
	
	echiquier = new Case [longueur][largeur];
	for (int i = 0; i < longueur ; i++){
	    for(int j = 0; j < largeur ; j++){
		if((i +j) % 2 == 0)
		    echiquier[i][j] = new Case(i, j, true);
		else
		    echiquier[i][j] = new Case(i, j, false);
	    }
	}
	
    }

    /***************************************************************************************************************************************/
    
    public void afficher(){
	
	//Centrage du tableau
	for(i = 0; i < 10; i++){
	    System.out.print("\v");
	    if(i < 6)
		System.out.print("\t");
	}
       
	//On affiche d'abord les coordonnées horizontales
	System.out.print("   ");
	for(int i = 0; i < largeur; i++)
	    System.out.print(i + "  ");
	System.out.println("\n");
     
	for(i = 0; i < 5; i++)
	    printf("\t");
	
	Piece tmp; //Pour chaque piece dans chaque case de l'échiquier
	
	for(int i = 0; i < longueur; i++){
	    for(int j = 0; j < largeur; j++){
		System.out.print(i + "  ");
		if(echiquier[i][j].estVide())
		    System.out.print("."); //Les cases vides seront représentés par un point
		else{
		    tmp = echiquier[i][j].getPiece();
		    tmp.pieceAfficher();
		}
	    }
	    System.out.println();
	    
	    for(k = 0; k < 5 ; k++)
		System.out.print("\t");

	}
	
	System.out.println("\n\n\n");
	
    }

    /***************************************************************************************************************************************/
    
    public Case giveCase(int y, int x){
	return echiquier[y][x];
    }

    /***************************************************************************************************************************************/
    
    public boolean deplace(Mouvement m, boolean joueur){

	


	}

    }
	    
    /***************************************************************************************************************************************/
    
    public void initialisation(){

	//Camp du joueur Blanc
	
	//Remplissage de la première ligne de l'échiquier

	Piece tmp = new Piece(true, 'T');
	echiquier[0][0].fill(p);
	
	tmp = new Piece(true, 'C');
	echiquier[0][1].fill(p);

	tmp = new Piece(true, 'F');
	echiquier[0][2].fill(p);

	tmp = new Piece(true, 'R');
	echiquier[0][3].fill(p);

	tmp = new Piece(true, 'E');
	echiquier[0][4].fill(p);

	tmp = new Piece(true, 'F');
	echiquier[0][5].fill(p);

	tmp = new Piece(true, 'C');
	echiquier[0][6].fill(p);

	tmp = new Piece(true, 'T');
	echiquier[0][7].fill(p);
	
	//Remplissage de la deuxième ligne de l'échiquier
	p = new Piece(true, 'P');
	for(int j = 1; j < largeur; j++)
	    echiquier[0][j].fill(p);
	
	
	//Camp du joueur Noir
	
	//Remplissage de la première ligne du camp, avant - dernière ligne de l'échiquier
	p = new Piece(false, 'p');
	for(int j = 0; j < largeur; j++)
	    echiquier[6][j].fill(p);
	
	//Remplissage de la deuxième ligne du camp, dernière ligne de l'échiquier
	
	p = new Piece(false, 't');
	echiquier[7][0].fill(p);
	
	p = new Piece(false, 'c');
	echiquier[7][1].fill(p);
	
	p = new Piece(false, 'f');
	echiquier[7][2].fill(p);

	p = new Piece(false, 'r');
	echiquier[7][3].fill(p);

	p = new Piece(false, 'e');
	echiquier[7][4].fill(p);
	
	p = new Piece(false, 'f');
	echiquier[7][5].fill(p);

	p = new Piece(false, 'c');
	echiquier[7][6].fill(p);

	p = new Piece(false, 't');
	echiquier[7][7].fill(p);

	//Les autres cases restent vides
	
    }

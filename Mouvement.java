public class Mouvement{
    
    private Case depart;
    private Case arrivee;
    
    private int[] t1 = depart.getCoordonnees(); //Coordonnées de la case de départ
    private int[] t2 = arrivee.getCoordonnees(); //Coordonnées de la case d'arrivée
    
    public Mouvement(Case depart, Case arrivee){
	
	this.depart = depart;
	this.arrivee = arrivee;
	
    }

    /**************************************************************************************************************************************/
    /**
       On ne permettra pas d'exécuter un déplacement en passant par dessus d'une autre piece (sauter une piece)
       Cette fonction teste si toutes les cases situées sur la ligne reliant la case de départ à la case de destination 
       privé de celles de depart et de destination sont inoccupées.
       @param le plateau de la partie
       @param la case de départ et celle d'arrivée
       @return vrai s'il n'y a pas de pièces présents sur cette ligne, faux sinon
    */
    public boolean testCases(Plateau p){
	
	Case c;
	
	if(deplacementHorizontal()){
	    
	    if(t2[0] > t1[0]){
		for(int i = (t1[0] + 1); i < t2[0]; i++){ //On ne teste ni la case de depart ni celle d'arrivee
		    c = p.giveCase(t1[1], i);
		    if(!c.estVide())
			return false; 
		}
	    }
	    else{
		for(int i = (t1[0] - 1); i > t2[0]; i--){
		    c = p.giveCase(t1[1], i);
		    if(!c.estVide())
			return false; 
		}
	    }
	    //On sort de la boucle si toutes les cases parcourues sont vides
	    
	    return true;
	}
	
	if(deplacementVertical()){
	    
	    if(t2[1] > t1[1]){
		for(int i = (t1[1] + 1); i < t2[1]; i++){ //On part de la case de départ à la case d'arrivée
		    c = p.giveCase(i, t1[0]);
		    if(!c.estVide())
			return false; 
		}
	    }
	    else{
		for(int i = (t1[1] - 1); i > t2[1]; i--){
		    c = p.giveCase(i, t1[0]);
		    if(c.estVide())
			return false; 
		}
	    }
	    
	    return true; //IDEM que prec
	}
	
	
	if(deplacementDiagonal()){
	    
	    if(t2[1] < t1[1] && t2[0] < t1[0]){
		for(int i = (t1[1] - 1); i > t2[1]; i--){
		    for(int j = (t1[0] - 1); j > t2[0]; j--){
			c = p.giveCase(i, j);
			if(!c.estVide())
			    return false;
		    }
		}
	    }
	    
	    else if(t2[1] > t1[1] && t2[0] > t1[0]){
		for(int i = (t1[1] + 1);  i < t2[1]; i--){
		    for(int j = (t1[0] + 1); j < t2[0]; i--){
			c = p.giveCase(i, j);
			if(!c.estVide())
			    return false;
		    }
		}
	    }
	    
	    else if(t2[1] > t1[1] && t2[0] < t1[0]){
		for(int i = (t1[1] + 1); i < t2[1]; i++){
		    for(int j = (t1[0] - 1); j > t2[0]; j--){
			c = p.giveCase(i, j);
			if(!c.estVide())
			    return false;
		    }
		}
	    }
	    
	    else if(t2[1] < t1[1] && t2[0] > t1[0]){
		for(int i = (t1[1] - 1); i > t2[1]; i--){
		    for(int j = (t1[0] + 1); j < t2[0]; j++){
			c = p.giveCase(i, j);
			if(!c.estVide())
			    return false;
		    }
		} 
	    }
	    
	    return true;
	    
	}
	
	return false; //Ce n'est aucun des trois types de deplacements; ce qui n'arrivera jamais
    }
    
    /*******************************************LES TYPES DE DEPLACEMENTS*****************************************************************/
    /**
       Les types de deplacements verifient si un deplacement est vertical ou horizontal ou diagonal à la case de depart
       On ne s'occupe pas des propoertions du plateau car bien avant d'appeler Mouvement, on s'assurera qu'on ne dépasse 
       pas les proportions du plateau
       @param les cases de depart et d'arrivee
       @return vrai si le deplacement est du type, faux sinon
    */

    /**
       L'ordonnée ne varie pas donc on reste sur la meme ligne droite horizontale: le deplacement est horizontal
    */
    public boolean deplacementHorizontal(){
	
	if(t2[1] == t1[1] && t2[0] != t1[0])
	    return true;
	return false;
	
    }
    
    /**
       L'abssice ne varie pas donc on reste sur la meme ligne droite verticale: le deplacement est vertical
    */ 
    public boolean deplacementVertical(){
	
	if(t2[0] == t1[0] && t2[1] != t1[1])
	    return true;
	return false;
	
    }
    
    public boolean deplacementDiagonal(){
	
	for(int i = 1; i < 7; i++){ /*On pourra sortir des coordonnées de l'échiquier mais on ne  risque rien car si ça arrive, arrivée sera toujours différents de depart +/- i dans ce cas*/
	    
	    if(Math.abs(t2[1] - t1[1]) == i && Math.abs(t2[0] - t1[0]) == i) 
		return true;
	}
	
	return false;
	
    }
    
    /**************************************************************************************************************************************/

    
    public boolean isValid(Plateau p, boolean joueur){
	
	Piece p1, p2;
	boolean coul1, coul2;
	
	if(!depart.estVide()){ //La case de départ contient bien une puece
	    p1 = depart.getPiece();
	    coul1 = p1.getCouleur();
	    p2 = arrivee.getPiece();
	    coul2 = p2.getCouleur();
	    if(joueur == coul1 && joueur != coul2){ //Le joueur joue bien avec une piece qui est sienne et n'essaie pas de capturer une piece qui lui appartienne
		if(p1.isValid(p, arrivee) && testCases(p))
		    return true;
	    }
	}
	return false;
	
    }

    /***************************************************************************************************************************************/
    
    public void faire(Plateau p){

	Case cDepart = p.getCase(t1[0], t1[1]);
	Case cArrivee = p.getCase(t2[0], t2[1]);
	Piece piece = cDepart.getPiece();
	cDepart.removePiece();
	if(!cArrivee.estVide())
	    cArrivee.removePiece();
	cArrivee.fill(piece);
	
    }
    
}

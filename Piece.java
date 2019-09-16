public class Piece{

    private boolean pieceCouleur;
    private Case pieceCase;
    private String nom;
    
    public Piece(boolean pieceCouleur, String nom){
	
	this.pieceCouleur = pieceCouleur;
	this.pieceCase = pieceCase;
	this.nom = nom;
	
    }

    /***************************************************************************************************************************************/
    
    public boolean getCouleur(){
	return this.pieceCouleur;
    }

    /**************************************************************************************************************************************/
    
    public void pieceAfficher(){
	System.out.print(this.nom);
    }

    /**************************************************************************************************************************************/
    
    public boolean isValid(Plateau p, Case arrivee){
	return true;
    }

    /**************************************************************************************************************************************/
    
}


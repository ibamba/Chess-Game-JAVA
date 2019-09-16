public class Case{

    private int abscisse, ordonnee;
    private boolean couleur;
    private Piece piece;
    
    public Case(int ordonnee, int abscisse, boolean couleur){
	this.ordonnee = ordonnee;
	this.abscisse = abscisse;
	this.couleur = couleur;
	this.piece = null;
    }

    /**************************************************************************************************************************************/
    
    public boolean estVide(){
	if(this.piece == null)
	    return true;
	return false;
    }

    /**************************************************************************************************************************************/
    
    public Piece getPiece(){
	return this.piece;
    }

    /***************************************************************************************************************************************/
    
    public int[] getCoordonnees(){
	
	int[] res = new int [2];
	res[0] = this.abscisse;
	res[1] = this.ordonnee;
	return res;
	
    }

    /***************************************************************************************************************************************/
    
    public void removePiece(){
	this.piece = null;
    }

    /**************************************************************************************************************************************/
    
    public void fill(Piece p){
	this.piece = p;
    }
    
}
	

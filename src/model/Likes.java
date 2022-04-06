package model;

/********************************************************************************************************* 
 *									PROTOTYPE CLASS STILL ON WORKS!!!
 *********************************************************************************************************/

public class Likes {
//-------------------------------------------- Class variables --------------------------------------------------
	private boolean liked;
	private boolean unliked;
	
/********************************************************************************************************* 
 * The following methods are self-explanatory,
 * hence require no comments to understand their purpose.
 *********************************************************************************************************/
//-------------------------------------------- Constructor method -----------------------------------------------
	public Likes() {
		boolean localLiked = true;
		boolean localUnliked = false;
		
		this.liked = localLiked;
		this.unliked = localUnliked;
	}

//----------------------------------------- getters and setters methods ----------------------------------
//Getters
	public boolean getLiked() {
		return liked;
	}
	
	public boolean getUnliked() {
		return unliked;
	}
	
//Setters
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	
	public void setUnliked(boolean unliked) {
		this.unliked = unliked;
	}
	
	
	
	
}

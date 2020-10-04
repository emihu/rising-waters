package risingWaters;

/** This program represents a player of the game
 * @version Final
 * @author Cindy Liu and Emily Hu
 * Due date: June 10th, 2019
 * Time Spent: 1 hour
 * 
 */
public class Player {
	//user name
	private String name;
	//number of points the user has in level 1
	private  int points1;
	//number of points the user has in level 2
	private  int points2;
	//number of points the user has in level 3
	private  int points3;

	/* Player class constructor
	 * 
	 */
	public Player (){
		name = "";
		points1 = 0;
		points2 = 0;
		points3 = 0;
	}

	/* Accessor method that returns the value of name
	 * 
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}

	/* Accessor method that returns the value of points1
	 * 
	 * @return the value of points1
	 */
	public int getPoints1() {
		return points1;
	}
	
	/* Accessor method that returns the value of points2
	 * 
	 * @return the value of points2
	 */
	public int getPoints2() {
		return points2;
	}
	
	/* Accessor method that returns the value of points3
	 * 
	 * @return the value of points3
	 */
	public int getPoints3() {
		return points3;
	}

	/* Mutator method to set the value of name
	 * 
	 * @param n The value of name to be set
	 */
	public void setName (String n) {
		this.name = n;
	}

	/* Mutator method to set the value of points1
	 * 
	 * @param poin The value of points1 to be set
	 */
	public void setPoints1 (int p1) {
		points1 = p1; 
	}
	
	/* Mutator method to set the value of points2
	 * 
	 * @param poin The value of points2 to be set
	 */
	public void setPoints2 (int p2) {
		points2 = p2; 
	}
	
	/* Mutator method to set the value of points1
	 * 
	 * @param poin The value of points1 to be set
	 */
	public void setPoints3 (int p3) {
		points3 = p3; 
	}

}

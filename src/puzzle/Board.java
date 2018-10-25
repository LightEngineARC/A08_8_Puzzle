/*
 * Authors: Whitney Smith and Ashton Chatelain
 */

package puzzle;

public class Board
{
	private int N;
	private int[] board;

	/**
	 * @param blocks
	 */
	public Board(int[][] blocks)
	{
		// TODO implement constructor
		//FIXME use a single array or a 2D array. regular array is significantly less memory.
	}

	public int size() {
		return N;
	}
	
	public int hamming() {
		return 0;//TODO the number of blocks out of place
	}
	
	public int manhattan()
	{
		// TODO  sum of Manhattan distances between blocks and goal
		return 0;
	}

	
	//TODO create n*n boards

	public boolean isGoal() {
		Board goalBoard;//TODO create a goal board for size N
		return false; //this.equals(goalBoard);
	}
	
	public boolean isSolvable()
	{
		// TODO implement isSolvable
		return false;
	}
	
	
	public boolean equals(Board b) {
		return false; //return this.equals(b);
	}

	



	public int tileAt(int row, int col)
	{
		// TODO implement
		return 0;
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		//TODO update this implementation
	    StringBuilder s = new StringBuilder();
//	    s.append(N + "\n");
//	    for (int i = 0; i < N; i++) {
//	        for (int j = 0; j < N; j++) {
//	            s.append(String.format("%2d ", tiles[i][j]));
//	        }
//	        s.append("\n");
//	    }
	    return s.toString();
	}
	
	
	
	// TEST CLIENT
	public static void main(String[] args) {
		
	}
}

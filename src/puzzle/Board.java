/*
 * Authors: Whitney Smith and Ashton Chatelain
 */

package puzzle;

public class Board
{

	/**
	 * @param blocks
	 */
	public Board(int[][] blocks)
	{
		// TODO implement constructor
		//FIXME decide to use a single array or a 2D array. regular array is significantly less memory.
	}

	/**
	 * Method     : NAME
	 *
	 * Purpose    : DESCRIPTION
	 *
	 * @params
	 *
	 * @returns
	 *
	 */
	public boolean isSolvable()
	{
		// TODO implement isSolvable
		return false;
	}
	//TODO create n*n boards

	/**
	 * Method     : NAME
	 *
	 * Purpose    : DESCRIPTION
	 *
	 * @params
	 *
	 * @returns
	 *
	 */
	public int manhattan()
	{
		// TODO implement
		return 0;
	}

	/**
	 * Method     : NAME
	 *
	 * Purpose    : DESCRIPTION
	 *
	 * @params
	 *
	 * @returns
	 *
	 */
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
}

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
		this.N = blocks.length;
		board = new int[N*N];
		int row = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<N;j++) {
				board[row+j]=blocks[i][j];
			}
			row = row+N;
		}
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
	
	public int[] getBoard() {
		return this.board;
	}
	public int getSize() {
		return N;
	}
	
	
	
	// TEST CLIENT
	public static void main(String[] args) {
		int[][] array = {{1,2,3},{4,5,6},{7,8,0}};
		Board board = new Board(array);
		
		testPrint(board);
		
		int[][] array2 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,0}
		};
		Board board2 = new Board(array2);
		testPrint(board2);
		
		
		
	}
	private static void testPrint(Board b) {
		System.out.println(b.getSize());
		
		for(int i = 0;i<b.getSize()*b.getSize();i++) {
			System.out.print(" "+b.getBoard()[i]+" ");
		}
		System.out.println("\n");
		
	}
}

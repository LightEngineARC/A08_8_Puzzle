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
		int count = 0;
		for(int i=0;i<this.size()*this.size()-1;i++) {
			if(this.board[i] != i+1) {
				count++;
			}
		}
		return count;//the number of blocks out of place not counting the zero
	}
	
	public int manhattan()
	{
		// TODO  sum of Manhattan distances between blocks and goal
		return 0;
	}


	public boolean isGoal() {
		for(int i=0;i<this.size()*this.size();i++) {
			if(board[i]!=0) {
			if(board[i]!=i+1) {
				return false;
			}
			}
		}
		return true;
	}
	
	public boolean isSolvable()
	{
		//if board size even
		
		//if board size odd
		
		// TODO implement isSolvable
		return false;
	}
	
	public boolean equals(Board b) {
		if(this.size()!=b.size())
			return false;
		int[] thatBoard = b.getBoard();
		for(int i= 0;i<board.length;i++) {
			if(this.board[i] != thatBoard[i]) {
				return false;
			}
		}
		return true;
	}


	public int tileAt(int row, int col)
	{
		return board[row*N + col];
	}
	
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	    StringBuilder s = new StringBuilder();
	    s.append(N + "\n");
		
		for(int i = 0;i<this.size()*this.size();i++) {
			s.append(""+this.getBoard()[i]+" ");
			if((i+1)%this.size()==0) {
				s.append("\n");
			}
		}	    
	    return s.toString();
	}
	
	public int[] getBoard() {
		return this.board;
	}


	
	
	// =============================================================
	// ++++++++++++++++     TEST CLIENT     ++++++++++++++++++++++++
	// =============================================================
	public static void main(String[] args) {
		int[][] array = {{1,2,3},{4,5,6},{7,8,0}};
		Board board = new Board(array);
		assert(board.tileAt(0, 0)==1);
		assert(board.tileAt(0, 1)==2);
		assert(board.tileAt(0, 2)==3);
		assert(board.tileAt(1, 0)==4);
		assert(board.tileAt(1,1)==5);
		assert(board.tileAt(1,2)==6);
		assert(board.tileAt(2, 0)==7);
		assert(board.tileAt(2, 1)==8);
		assert(board.tileAt(2, 2)==0);
		assert(board.hamming()==0);
		testPrint(board);
		int[][] array2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{14,13,15,0}};
		Board board2 = new Board(array2);
		testPrint(board2);
		assert(board2.hamming()==2);
		
		
		
	}
	private static void testPrint(Board b) {
		System.out.print(b.toString());
		System.out.println("Is goal? "+b.isGoal());
		System.out.println("tile at N,N: " +b.tileAt(b.size()-1, b.size()-1)+"\n");
	}
}

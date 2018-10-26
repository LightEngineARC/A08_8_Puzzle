/*
 * Authors: Whitney Smith and Ashton Chatelain
 */

package puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board
{
	private int N;
	private int[] board;

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
	public Board(int[] board) {
		this.board = board;
		this.N = (int) Math.sqrt(board.length);
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
		//sum of Manhattan distances between blocks and goal
		int sum=0;
		for(int i=0; i<board.length;i++) {
			sum += distance(board[i]);
		}
		return sum;
	}

	public boolean isSolvable()
	{
		//if board size even
		//if board size odd
		// TODO implement isSolvable
		return false;
	}
	
	public Iterable<Board> neighbors(){
		Queue<Board> queue = new Queue<Board>();
		//TODO return an iterable
		int space = find(0);
		int row = space/N;
		int col = space%N;
		int[] theNeighbors = hasNeighbors(space);
		if(theNeighbors[0]==1) {
			queue.enqueue(swap(row,col,row-1,col));
		}
		if(theNeighbors[1]==1) {
			queue.enqueue(swap(row,col-1,row,col));
		}
		if(theNeighbors[2]==1) {
			queue.enqueue(swap(row,col,row,col+1));
		}
		if(theNeighbors[3]==1) {
			queue.enqueue(swap(row,col,row+1,col));
		}
		
		return queue;
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
	private Board swap(int row1, int col1, int row2, int col2)
	{
		//TODO swap a number with the zero
		Board board2 = new Board(board.clone());
		board2.setTile(row1*N, col1, board[row2*N+col2]);
		board2.setTile(row2*N, col2, board[row1*N+col1]);
		
		return board2;
	}

	private int[] hasNeighbors(int space) {
		int[] theNeighbors = {1,1,1,1};
		if(space<N)
			theNeighbors[0]=0;
		if(space>N*N-N)
			theNeighbors[3]=0;
		if(space%N==0)
			theNeighbors[1]=0;
		if(space%N==N-1)
			theNeighbors[2]=0;
		
		return theNeighbors;
	}
	
//	private Board swap() {
//		
//	}
	
	
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
	
	/*
	 * finds the distance a number needs to move to be in place.
	 */
	private int distance(int number) {
		//get the distance a number must move.
		if(number==0)
			return 0;
		
		int row = find(number)/N;
		int col = find(number)%N;
	
		return Math.abs(row-(number-1)/N)+Math.abs(col-(number-1)%N);
		
	}
	
	/*
	 * finds the row and column of an integer
	 */
	private int find(int n) {
		for(int i = 0;i<board.length;i++) {
			if(n==board[i]) {
				return i;
			}
		}
		return -1;
	}


	public int tileAt(int row, int col)
	{
		return board[row*N + col];
	}
	private void setTile(int row, int col, int number) {
		
		this.board[row+col]=number;
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
			if((i+1)%N==0) {
				s.append("\n");
			}
		}	    
	    return s.toString();
	}
	
	private int[] getBoard() {
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
		assert(board.manhattan()==0);
		testPrint(board);
		int[][] array2 = {{1,12,3,4},{5,6,7,8},{9,10,11,2},{14,13,15,0}};
		Board board2 = new Board(array2);
		testPrint(board2);
		assert(board2.hamming()==4);
		assert(board2.distance(14)==1);
		assert(board2.distance(12)==4);
		assert(board2.manhattan()==10);
		int[][] array3 = {{1,2,3},{4,5,6},{7,0,8}};
		Board board3 = new Board(array3);
		Board board4 = board3.swap(2, 2, 2, 1);
		Board board5 = board3.swap(1, 1, 2, 1);
		testPrint(board4);
		
		//TEST NEIGHBORS
		System.out.println("-----------------TEST NEIGHBORS------------------");
		testPrint(board5);
		for(Board b : board5.neighbors()) {
			testPrint(b);
		}
		
		
	}
	private static void testPrint(Board b) {
		System.out.print(b.toString());
		System.out.println("Hamming = "+b.hamming());
		System.out.println("Manhattan = "+b.manhattan());
		System.out.println("Is it a goal board? "+b.isGoal()+"\n");
	}
}

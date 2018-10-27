// Authors: Whitney Smith and Ashton Chatelain
// CSIS 2420
// Last Edited: 10/27/18

package puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver
{
	private Stack<Board> solution;
	private int moves;
	
	private class Move implements Comparable<Move>{
		private Board board;
		private int moves;
		private Move parent;
		
		// initializer
		public Move(Board board, int moves, Move parent){
			this.board = board;
			this.moves = moves;
			this.parent = parent;
		}

		// override the compareTo function
		@Override
		public int compareTo(Move o) {
			int difference = this.board.manhattan() + this.moves - o.board.manhattan() - o.moves;
			if (difference != 0) {
				return difference;
			}
			if (this.moves > o.moves) {
				return -1;
			}
			return 1;
		}
	}

	public Solver(Board initial) {
		// find a solution to the initial board (using the A* algorithm)
		if (initial.isSolvable() == false) {
			throw new IllegalArgumentException();
		}
		
		solution = new Stack<>();
		MinPQ<Move> queue = new MinPQ<>();
		queue.insert(new Move(initial, 0, null));
		while(true){
			Move move = queue.delMin();
			if(move.board.isGoal()){ //goal has been reached, populate fields of interest and return
				this.moves = move.moves;
				do{
					solution.push(move.board);
					move = move.parent;
				}
				while(move != null);
				return; //done solving
			}
			for(Board next : move.board.neighbors()){
				if(move.parent == null || !next.equals(move.parent.board)) //look back one move to prevent useless looping
					queue.insert(new Move(next, move.moves+1, move));
			}
		}
	}
	
	public int moves(){
		// min number of moves to solve initial board
		return moves;
	}

	public Iterable<Board> solution(){
		// sequence of boards in a shortest solution
		return solution;
	}
	
	// ===========================================
	//TEST CLIENT
	// ===========================================
	public static void main(String[] args) {

	    // create initial board from file
	    In in = new In(args[0]);
	    int N = in.readInt();
	    int[][] blocks = new int[N][N];
	    for (int i = 0; i < N; i++)
	        for (int j = 0; j < N; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);

	    // check if puzzle is solvable; if so, solve it and output solution
	    if (initial.isSolvable()) {
	        Solver solver = new Solver(initial);
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }

	    // if not, report unsolvable
	    else {
	        StdOut.println("Unsolvable puzzle");
	    }
	}
}

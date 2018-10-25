package puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Solver
{

	public Solver(Board initial) 	 
	{
		// TODO find a solution to the initial board (using the A* algorithm)
		 
	}
	

	public int moves()
	{
		// TODO min number of moves to solve initial board
		return 0;
	}


	public Iterable<Board> solution()
	{
		// TODO // sequence of boards in a shortest solution
		return null;
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

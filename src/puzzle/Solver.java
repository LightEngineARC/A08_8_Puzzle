package puzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver
{
	private SearchNode solutionNode;

	public Solver(Board initial) 	 
	{
		MinPQ<SearchNode> queue = new MinPQ<SearchNode>();
		queue.insert(new SearchNode(initial));
		
		
		 MinPQ<SearchNode> queue2 = new MinPQ<SearchNode>();
		queue2.insert(new SearchNode(initial.twin()));

	        while(true) {
	        	solutionNode = expand(queue);
	            if (solutionNode != null|| expand(queue2) != null) return;
	        }
	    }
	
	private SearchNode expand(MinPQ<SearchNode> nodes) {
        if(nodes.isEmpty()) return null;
        SearchNode bestMove = nodes.delMin();
        if (bestMove.board.isGoal()) return bestMove;
        for (Board neighbor : bestMove.board.neighbors()) {
            if (bestMove.previous == null || !neighbor.equals(bestMove.previous.board)) {
            	nodes.insert(new SearchNode(neighbor, bestMove));
            }
        }
        return null;
    }
	

	public int moves()
	{
		//min number of moves to solve initial board
		return solutionNode.moves;
	}


	public Iterable<Board> solution()
	{
		// sequence of boards in a shortest solution
		Stack<SearchNode> stack  = new Stack<SearchNode>();
		Queue<Board> queue = new Queue<Board>();
		stack.push(solutionNode);
		while(stack.peek().previous != null)
			stack.push(stack.peek().previous);
		
		while(!stack.isEmpty())
			queue.enqueue(stack.pop().board);
		
		return queue;
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

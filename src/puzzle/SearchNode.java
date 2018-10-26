package puzzle;

public class SearchNode
{
	private Board board;
	private int moves;
	private int priority;
	public SearchNode previous;
	

	public SearchNode(Board b, int moves, int priority, SearchNode previous) {
		this.board = b;
		this.moves = moves;
		this.priority = priority;
		this.previous = previous;
	}
	
	public int nodeHamming() {
		return board.hamming();
	}
	public int nodeManhattan() {
		return board.manhattan();
	}
}

package puzzle;

public class SearchNode implements Comparable<SearchNode>
{
	public Board board;
	private int moves = 0;
	public SearchNode previous;
	

	public SearchNode(Board b, int moves, SearchNode previous) {
		this.board = b;
		this.moves = previous.moves+1;
		this.previous = previous;
	}
	public SearchNode(Board b, SearchNode previous) {
		this.board = b;
		this.moves = previous.moves+1;
		this.previous = previous;
	}
	public SearchNode(Board b) {
		this.board = b;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(SearchNode node)
	{
		return (this.board.manhattan()-node.board.manhattan())+(this.moves-node.moves);
	}
}

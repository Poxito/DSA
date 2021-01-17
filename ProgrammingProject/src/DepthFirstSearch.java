import java.util.Stack;

public class DepthFirstSearch {

	private boolean[] marked;	//marked[v] 
	private int[] egdeTo;		//
	private final int s;		//source vertex

	public DepthFirstSearch(Graph G, int s) {
		this.s = s;
		egdeTo = new int[G.getV()];
		marked = new boolean[G.getV()];
		dfs(G,s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if(!marked[w]) {
				egdeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Stack<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = egdeTo[x]) 
			path.push(x);
		path.push(s);
		return path;
	}
	
}

import java.lang.reflect.Array;
import java.util.Stack;

public class BreadthFirstSearch {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BreadthFirstSearch(Graph G, int s){
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		distTo = new int[G.getV()];
		bfs(G, s);
	}

	public BreadthFirstSearch(Graph G, Iterable<Integer> sources){
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		distTo = new int[G.getV()];
		for(int i=0; i<G.getV(); i++) distTo[i] = INFINITY;
		bfs(G, sources);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		for(int i=0; i<G.getV();i++) distTo[i] = INFINITY;
		distTo[s] = 0;
		marked[s] = true;
		queue.enqueue(s);
		
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v]+1;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	
	private void bfs(Graph G, Iterable<Integer> sources) {
		Queue<Integer> queue = new Queue<Integer>();
		for(int s: sources) {
			distTo[s] = 0;
			marked[s] = true;
			queue.enqueue(s);
		}
		
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v]+1;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public int distTo(int v) {
		return distTo[v];
	}
	
	public Stack<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for (x=v; distTo[x] != 0; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(x);
		return path;
	}
}

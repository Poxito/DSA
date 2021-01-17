import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.String;
	
public class Graph {
	
	private final int V;
	private int E;
	protected Bag<Integer>[] adj;
	protected Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	protected ArrayList<Friend> al = new ArrayList<Friend>();
	
	public Graph(int V) {
		if(V<0) throw new IllegalArgumentException("Number of vertices must be positive");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i<V; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public Graph(int V, int E, String path1, String path2, String idUser) throws FileNotFoundException {
		this.V = V;
		if(E<0)throw new IllegalArgumentException("Number of edges must be positive");
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i<V; i++){
			adj[i] = new Bag<Integer>();
		}
		for(int i=0; i<E; i++){
			this.charge(path1, path2);
		}
	}
	
	public int getV() {
		return V;
	}
	
	public int getE() {
		return E;
	}
	
	public Bag<Integer>[] getADJ(){
		return adj;
	}
	
	public void addEdge(int v, int w) {
		if(v<0 || v>=V) throw new IndexOutOfBoundsException();
		if(w<0 || w>=V) throw new IndexOutOfBoundsException();
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v){
		if(v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v];
	}
	
	public void charge(String path, String path2) throws FileNotFoundException {
		
		String line, line2 = "";  
		String splitBy = ",";
		int i = 0;
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(new File(path));
        
		while (scnr.hasNextLine()) {  
			line = scnr.nextLine();
			String[] info = line.split(splitBy); // use comma as separator
			Friend user = new Friend(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10]);
			al.add(user);
			ht.put(info[0], i);
			i++;
		}
		
		Scanner scnr2 = new Scanner(new File(path2)); 
		
		while (scnr2.hasNextLine()) {  
			line2 = scnr2.nextLine();
			String[] info2 = line2.split(splitBy); // use comma as separator
			if(ht.get(info2[0]) != null && ht.get(info2[1]) != null)
				addEdge(ht.get(info2[0]), ht.get(info2[1]));
		}
		
		scnr.close();
		scnr2.close();
	}
	
	public int returnHashtableValue(String idUser) {
		return ht.get(idUser);
	}
	
}

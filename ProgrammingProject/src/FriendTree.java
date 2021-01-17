import java.util.*;

public class FriendTree {
	protected int numberOfClasses;
	protected String classes;
	protected FriendNode root;
	
	public FriendTree(FriendNode friendNode) {
		numberOfClasses = 0;
		this.root = friendNode;
	}
	
	public void addProfile(String film, String user) {
		if(root.getFirstChild() == null) {
			FriendNode newFriend = new FriendNode(film, user);
			root.setFirstChild(newFriend);
			//root.getFirstChild().setFilm(film);
		}
		//addtheword(root.getFirstChild; pelikulak; 
	}
	
	
	public void addTheFilm (FriendNode fn, String keyWord) {
		if(fn.getFilm() == keyWord) {
			//if pelikula danak aztertu dia?
			//pelikulak gehitu clasera
			//else
			if(fn.getFirstChild()==null) {
				FriendNode newNode = new FriendNode();
				fn.setFirstChild(newNode);
			}
			//addtheword(...
		}else {
			if(fn.getSiblings()==null) {
				FriendNode newNode = new FriendNode();
				fn.setSiblings(newNode);
			}
			//addtheword...
		}
	}
	
	/*
	public void addTheFilm (FriendNode fn, ArrayList<String> user, ArrayList<String> film) {
		int i = 0;
		String[] theFilms;
		while(theFilms.length > 0){
			if(
		}
				
	}*/
}

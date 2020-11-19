import java.util.*;

public class FriendTrie {
	protected int numberClasses;
	protected String classes;
	protected FriendNode<Friend> root;
	
	public FriendTrie(FriendNode<Friend> friendNode) {
		this.root = friendNode;
	}
	
	public void addProfile(String film) {
		if(root.getFirstChild() == null) {
			FriendNode<Friend> newFriend = new FriendNode<Friend>(film);
			root.setFirstChild(newFriend);
		}
		//addtheword(root.getFirstChild; pelikulak; 
	}
	
	public void splitTheFilms(String films) {
		
	}
	
	public void addTheFilm (FriendNode<Friend> fn, String keyWord) {
		if(fn.getInfo() == keyWord) {
			//if pelikula dana aztertu dia?
			//pelikulak gehitu clasera
			//else
			if(fn.getFirstChild()==null) {
				FriendNode<Friend> newNode = new FriendNode<Friend>();
				fn.setFirstChild(newNode);
			}
			//addtheword(...
		}else {
			if(fn.getSiblings()==null) {
				FriendNode<Friend> newNode = new FriendNode<Friend>();
				fn.setSiblings(newNode);
			}
			//addtheword...
		}
	}
}

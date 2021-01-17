
public class FriendNode {
	
	protected String film;
	protected String users;
	protected FriendNode firstChild, siblings;
	
	
	public FriendNode(){
		this.film = "";
		this.users = "";
		firstChild = null;
		siblings = null;
	}
	
	public FriendNode(String film){
		this.film = film;
		this.users = "";
		firstChild = null;
		siblings = null;
	}
	
	public FriendNode(String profile, String user){
		this.film = profile;
		this.users = user;
		firstChild = null;
		siblings = null;
	}
	
	public FriendNode getFirstChild(){
		return this.firstChild;
	}
	
	public FriendNode getSiblings(){
		return this.siblings;
	}
	
	public void setFirstChild(FriendNode node) {
		this.firstChild = node;
	}
	
	public void setSiblings(FriendNode node) {
		this.siblings = node;
	}
	
	public String getFilm() {
		return film;
	}
	
	public void setFilm(String info) {
		this.film=info;
	}
	
	public String getUsers() {
		return users;
	}
	
	public void setUsers(String user) {
		this.users = this.users + user;
	}
}

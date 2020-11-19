
public class FriendNode<Friend> {
	//private String element;
	//private boolean isKey;
	//private Friend valueKey;
	//private TrieNode<Friend> firstChild;
	//private TrieNode<Friend> nextSibling;
	
	//protected Friend parent;
	protected FriendNode<Friend> firstChild, siblings;
	protected String info;
	
	public FriendNode(){
		this.info=" ";
		firstChild=null;
		siblings=null;
	}
	
	public FriendNode(String something){
		this.info = something;
		firstChild=null;
		siblings=null;
	}
	
	public FriendNode<Friend> getFirstChild(){
		return this.firstChild;
	}
	
	public FriendNode<Friend> getSiblings(){
		return this.siblings;
	}
	
	public void setFirstChild(FriendNode<Friend> node) {
		this.firstChild = node;
	}
	
	public void setSiblings(FriendNode<Friend> node) {
		this.siblings = node;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info=info;
	}
}

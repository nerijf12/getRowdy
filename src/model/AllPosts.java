package model;

import java.util.LinkedList;

public class AllPosts {
	private LinkedList<Post> allPostAList;

	public AllPosts(){
		 allPostAList = new LinkedList<Post>();
	 }
	 public void addPost(Post post) {
			allPostAList.add(post);
	}
	 public void removePost(Post post) {
			allPostAList.remove(post);
	}
	public LinkedList<Post> getAllPostAList() {
		return allPostAList;
	}
	public void setAllPostAList(LinkedList<Post> allPostAList) {
		this.allPostAList = allPostAList;
	}

}

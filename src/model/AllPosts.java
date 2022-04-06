package model;

import java.util.ArrayList;

public class AllPosts {
	private ArrayList<Post> allPostAList;

	public AllPosts(){
		 allPostAList = new ArrayList<Post>();
	 }
	 public void addPost(Post post) {
			allPostAList.add(post);
	}
	 public void removePost(Post post) {
			allPostAList.remove(post);
	}
	public ArrayList<Post> getAllPostAList() {
		return allPostAList;
	}
	public void setAllPostAList(ArrayList<Post> allPostAList) {
		this.allPostAList = allPostAList;
	}

}

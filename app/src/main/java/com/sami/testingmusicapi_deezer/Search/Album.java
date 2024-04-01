package com.sami.testingmusicapi_deezer.Search;

public class Album{
	private String cover;
	private String md5Image;
	private String tracklist;
	private String coverXl;
	private String coverMedium;
	private String coverSmall;
	//private long id;
	private String title;
	private String type;
	private String cover_big;

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return cover;
	}

	public void setMd5Image(String md5Image){
		this.md5Image = md5Image;
	}

	public String getMd5Image(){
		return md5Image;
	}

	public void setTracklist(String tracklist){
		this.tracklist = tracklist;
	}

	public String getTracklist(){
		return tracklist;
	}

	public void setCoverXl(String coverXl){
		this.coverXl = coverXl;
	}

	public String getCoverXl(){
		return coverXl;
	}

	public void setCoverMedium(String coverMedium){
		this.coverMedium = coverMedium;
	}

	public String getCoverMedium(){
		return coverMedium;
	}

	public void setCoverSmall(String coverSmall){
		this.coverSmall = coverSmall;
	}

	public String getCoverSmall(){
		return coverSmall;
	}

//	public void setId(long id){
//		this.id = id;
//	}

//	public long getId(){
//		return id;
//	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCoverBig(String coverBig){
		this.cover_big = coverBig;
	}

	public String getCoverBig(){
		return cover_big;
	}
}

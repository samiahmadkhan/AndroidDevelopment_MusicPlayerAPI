package com.sami.testingmusicapi_deezer.Search;

public class Artist{
	private String pictureXl;
	private String tracklist;
	private String picture_big;
	private String name;
	private String link;
	private String pictureSmall;
//	private long id;
	private String type;
	private String picture;
	private String pictureMedium;

	public void setPictureXl(String pictureXl){
		this.pictureXl = pictureXl;
	}

	public String getPictureXl(){
		return pictureXl;
	}

	public void setTracklist(String tracklist){
		this.tracklist = tracklist;
	}

	public String getTracklist(){
		return tracklist;
	}

	public void setPicture_big(String picture_big){
		this.picture_big = picture_big;
	}

	public String getPicture_big(){
		return picture_big;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setPictureSmall(String pictureSmall){
		this.pictureSmall = pictureSmall;
	}

	public String getPictureSmall(){
		return pictureSmall;
	}

//	public void setId(long id){
//		this.id = id;
//	}
//
//	public long getId(){
//		return id;
//	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setPictureMedium(String pictureMedium){
		this.pictureMedium = pictureMedium;
	}

	public String getPictureMedium(){
		return pictureMedium;
	}
}

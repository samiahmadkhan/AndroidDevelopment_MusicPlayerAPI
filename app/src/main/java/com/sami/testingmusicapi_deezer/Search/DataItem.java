package com.sami.testingmusicapi_deezer.Search;

public class DataItem{
	private boolean readable;
	private String preview;
	private String md5Image;
	private Artist artist;
	private Album album;
	private String link;
	private int explicitContentCover;
	private String title;
	private String titleVersion;
	private boolean explicitLyrics;
	private String type;
	private String titleShort;
	private int duration;
	private int rank;
	private long id;
	private int explicitContentLyrics;

	public void setReadable(boolean readable){
		this.readable = readable;
	}

	public boolean isReadable(){
		return readable;
	}

	public void setPreview(String preview){
		this.preview = preview;
	}

	public String getPreview(){
		return preview;
	}

	public void setMd5Image(String md5Image){
		this.md5Image = md5Image;
	}

	public String getMd5Image(){
		return md5Image;
	}

	public void setArtist(Artist artist){
		this.artist = artist;
	}

	public Artist getArtist(){
		return artist;
	}

	public void setAlbum(Album album){
		this.album = album;
	}

	public Album getAlbum(){
		return album;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setExplicitContentCover(int explicitContentCover){
		this.explicitContentCover = explicitContentCover;
	}

	public int getExplicitContentCover(){
		return explicitContentCover;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setTitleVersion(String titleVersion){
		this.titleVersion = titleVersion;
	}

	public String getTitleVersion(){
		return titleVersion;
	}

	public void setExplicitLyrics(boolean explicitLyrics){
		this.explicitLyrics = explicitLyrics;
	}

	public boolean isExplicitLyrics(){
		return explicitLyrics;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitleShort(String titleShort){
		this.titleShort = titleShort;
	}

	public String getTitleShort(){
		return titleShort;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setExplicitContentLyrics(int explicitContentLyrics){
		this.explicitContentLyrics = explicitContentLyrics;
	}

	public int getExplicitContentLyrics(){
		return explicitContentLyrics;
	}
}

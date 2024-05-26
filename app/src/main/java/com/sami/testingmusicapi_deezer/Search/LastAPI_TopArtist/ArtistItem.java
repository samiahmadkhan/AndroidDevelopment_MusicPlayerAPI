package com.sami.testingmusicapi_deezer.Search.LastAPI_TopArtist;

import java.util.List;

public class ArtistItem{
	private List<ImageItem> image;
	private String mbid;
	private String listeners;
	private String streamable;
	private String playcount;
	private String name;
	private String url;

	public List<ImageItem> getImage(){
		return image;
	}

	public String getMbid(){
		return mbid;
	}

	public String getListeners(){
		return listeners;
	}

	public String getStreamable(){
		return streamable;
	}

	public String getPlaycount(){
		return playcount;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}
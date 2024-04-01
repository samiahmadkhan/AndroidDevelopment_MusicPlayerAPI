package com.sami.testingmusicapi_deezer.Search;

public class ArtistData{
	private String pictureXl;
	private String tracklist;
	private String link;
	private String pictureSmall;
	private String type;
	private int nbAlbum;
	private String picture;
	private int nbFan;
	private boolean radio;
	private String picture_big;
	private String name;
	private String share;
//	private long id;
	private String pictureMedium;

	public String getPictureXl(){
		return pictureXl;
	}

	public String getTracklist(){
		return tracklist;
	}

	public String getLink(){
		return link;
	}

	public String getPictureSmall(){
		return pictureSmall;
	}

	public String getType(){
		return type;
	}

	public int getNbAlbum(){
		return nbAlbum;
	}

	public String getPicture(){
		return picture;
	}

	public int getNbFan(){
		return nbFan;
	}

	public boolean isRadio(){
		return radio;
	}

	public String getPicture_big(){
		return picture_big;
	}

	public String getName(){
		return name;
	}

	public String getShare(){
		return share;
	}

//	public int getId(){
//		return id;
//	}

	public String getPictureMedium(){
		return pictureMedium;
	}
}

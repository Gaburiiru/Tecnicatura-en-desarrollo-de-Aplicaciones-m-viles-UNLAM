public class Song {
	private Integer id;
	private String name;
	private Float duration;
	private String album;
	private String artist;
	
	public Song(Integer id,String name, Float duration, String album, String artist) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.album = album;
		this.artist = artist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}

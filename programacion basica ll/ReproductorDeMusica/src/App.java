import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

	String name;
	List<User> listUser = new ArrayList<>();
	List<Song> listSong = new ArrayList<>();
	Map<User, Set<Song>> playList = new HashMap<>();

	public App(String name) {
		super();
		this.name = name;
	}

	public boolean insertUser(User user) throws CreateUser {
	    try {
	        listUser.add(user);
	        return true;
	    } catch (Exception e) {
	        throw new CreateUser();
	    }
	}

	public boolean insertSong(Song song) throws CreateSong {
		try {
	        listSong.add(song);
	        return true;
	    } catch (Exception e) {
	        throw new CreateSong();
	    }
	}

	public User searchUser(User user) throws UserNotFound {
		for (User userSearch : listUser) {
			if (user.getId().equals(userSearch.getId())) {
				return userSearch;
			}
		}
		throw new UserNotFound();
	}

	public Song searchSong(Song song) throws SongNotFound {
		for (Song songSearch : listSong) {
			if (song.getId().equals(songSearch.getId())) {
				return songSearch;
			}
		}
		throw new SongNotFound();
	}

	public Boolean createPlayList(User user, Song song) throws UserNotFound, SongNotFound, NotCreatePlaylist {
	    User userSearch = searchUser(user);
	    Song songSearch = searchSong(song);
	    if (userSearch != null && songSearch != null) {
	        // crear el conjunto de canciones del usuario
	        Set<Song> userPlayList = playList.getOrDefault(userSearch, new HashSet<>());

	        if (userPlayList.contains(songSearch)) {
	            throw new NotCreatePlaylist(); // Canción ya en la lista de reproducción
	        }

	        userPlayList.add(songSearch); // Agregar la canción al conjunto del usuario
	        playList.put(userSearch, userPlayList); // Actualizar la lista de reproducción

	        return true;
	    }
	    throw new NotCreatePlaylist();
	}
	
	public Set<Song> searchPlayListByUser(User user) throws UserNotFound {
	    User userSearch = searchUser(user);
	    if (userSearch != null) {
	        return playList.getOrDefault(userSearch, new HashSet<>());
	    } else {
	        throw new UserNotFound();
	    }
	}


}
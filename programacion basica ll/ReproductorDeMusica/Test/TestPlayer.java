import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void testQueSePuedaAgregarUnaCancionALaPlayList() throws CreateUser, CreateSong,NotCreatePlaylist, UserNotFound, SongNotFound{
		// preparacion
		String name = "juan", nameSong = "Put me thru", nameArtist = "anderson .paak", nameAlbum = "undefined",
				nameApp = "Play";
		Integer idUser = 1, idSong = 1, age = 20;
		Float duration = (float) 3.21;
		Boolean insertPlayList = false;
		// instanciacion objets
		App app = new App(nameApp);
		User user = new User(idUser, name, age);
		app.insertUser(user);
		Song song = new Song(idSong, nameSong, duration, nameAlbum, nameArtist);
		app.insertSong(song);
		insertPlayList = app.createPlayList(user, song);

		assertEquals(insertPlayList, true);
	}

	@Test(expected = NotCreatePlaylist.class)
	public void testQueNoSePuedaAgregarUnaCancionALaPlayListExistente()
			throws CreateUser, CreateSong, NotCreatePlaylist, UserNotFound, SongNotFound {
		// preparacion
		String name = "juan", nameSong = "Put me thru", nameArtist = "anderson .paak", nameAlbum = "undefined",
				nameApp = "Play";
		Integer idUser = 1, idSong = 1, age = 20;
		Float duration = (float) 3.21;
		Boolean insertPlayList = false, insertPlayList2 = false;
		// instanciacion objets
		App app = new App(nameApp);
		User user = new User(idUser, name, age);
		app.insertUser(user);
		Song song = new Song(idSong, nameSong, duration, nameAlbum, nameArtist);
		app.insertSong(song);
		Song song2 = new Song(idSong, nameSong, duration, nameAlbum, nameArtist);
		app.insertSong(song2);

		insertPlayList = app.createPlayList(user, song);
		insertPlayList2 = app.createPlayList(user, song2);
	}
	
	@Test
	public void testQueSePuedaBuscarLaPlayListPorUsuario() throws CreateUser, CreateSong,NotCreatePlaylist, UserNotFound, SongNotFound{
		// preparacion
		String name = "juan", nameSong = "Put me thru", nameArtist = "anderson .paak", nameAlbum = "undefined",
				nameApp = "Play";
		Integer idUser = 1, idSong = 1, age = 20;
		Float duration = (float) 3.21;
		Boolean insertPlayList = false;
		Set<Song> playList = null;
		// instanciacion objets
		App app = new App(nameApp);
		User user = new User(idUser, name, age);
		app.insertUser(user);
		Song song = new Song(idSong, nameSong, duration, nameAlbum, nameArtist);
		app.insertSong(song);
		insertPlayList = app.createPlayList(user, song);

		playList = app.searchPlayListByUser(user);
		assertNotNull(playList);
	}
}

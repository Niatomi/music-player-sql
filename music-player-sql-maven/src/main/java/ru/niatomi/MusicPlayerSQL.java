package ru.niatomi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author niatomi
 */
@SpringBootApplication
public class MusicPlayerSQL {
    public static void main(String[] args) {
        SpringApplication.run(MusicPlayerSQL.class, args);
    }
}
//    //Практика 11
//    //Основыне обекты
//
//    //Задание 2
//    ArtistDAO artist_dao = new ArtistDAO(DB_URL, DB_LOGIN, DB_PASSWORD);
//
//    //Задание 3
//    GenreDAO genre_dao = new GenreDAO(DB_URL, DB_LOGIN, DB_PASSWORD);
//
//    //Задание 4
//    SongDAO song_dao = new SongDAO(DB_URL, DB_LOGIN, DB_PASSWORD);
//
//    PlaylistDAO playlist_dao = new PlaylistDAO(DB_URL, DB_LOGIN, DB_PASSWORD);
//    Generator generator = new Generator();
//    View view = new View(DB_URL, DB_LOGIN, DB_PASSWORD);
//
////        playlist_dao.drop();
////        song_dao.drop();
////        artist_dao.drop();
////        genre_dao.drop();
////        System.out.println("");
//
//    //Практика 10
//    //Задания 1,2
//        artist_dao.create();
//        genre_dao.create();
//        song_dao.create();
//        playlist_dao.create();
//        System.out.println("");
//
//    //Генерируем значения для таблиц
//        generator.generate(artist_dao);
//        generator.generate(genre_dao);
//        generator.generate(song_dao);
//        generator.generate(playlist_dao);
//
//    //Задание 3
//        System.out.println("Создание представлений");
//        view.song_view();
//        view.playlist_song_view();
//
//    //Практика 11
//    //Проверка методов для SongDAO
//        System.out.println("Проверка метода insert");
//        System.out.println(song_dao.findSongsByArtist(6));
//        song_dao.insert(new Song("Forsaken", 6, 4, 67));
//        System.out.println(song_dao.findSongsByArtist(6));
//        System.out.println("");
//
//        System.out.println("Проверка метода findByKey");
//        System.out.println(song_dao.findByKey(10000008));
//        System.out.println("");
//
//        System.out.println("Проверка метода findSongsByArtist");
//        System.out.println(song_dao.findSongsByArtist(1));
//        System.out.println("");
//
//        System.out.println("Проверка метода findSongsByGenre");
//        System.out.println(song_dao.findSongsByGenre(1));
//        System.out.println("");
//
//        System.out.println("Проверка метода update");
//        System.out.println(song_dao.findSongsByArtist(4));
//        song_dao.update(10000005, new Song("Stranded", 4, 3, 121));
//        System.out.println(song_dao.findSongsByArtist(4));
//        System.out.println("");
//
//        System.out.println("Проверка методов updateSongName, updateSongArtist, updateSongGenre");
//        System.out.println(song_dao.findByKey(10000005));
//        song_dao.updateSongName(10000005, "Orion");
//        song_dao.updateSongArtist(10000005, new Artist("Metallica"));
//        song_dao.updateSongGenre(10000005, new Genre("Metal"));
//        System.out.println(song_dao.findByKey(10000005));
//        System.out.println("");
//
//        System.out.println("Проверка метода removeByKey");
//        System.out.println(song_dao.findSongsByArtist(6));
//        System.out.println(song_dao.removeByKey(10000010));
//        System.out.println(song_dao.findSongsByArtist(6));



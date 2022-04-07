/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Generator;

import java.util.ArrayList;
import java.util.List;
import musicplayersql.Classes.Generics.ArtistDAO;
import musicplayersql.Classes.Generics.GenreDAO;
import musicplayersql.Classes.Generics.PlaylistDAO;
import musicplayersql.Classes.Generics.SongDAO;
import musicplayersql.Classes.Substanses.Artist;
import musicplayersql.Classes.Substanses.Genre;
import musicplayersql.Classes.Substanses.Playlist;
import musicplayersql.Classes.Substanses.Song;

/**
 *
 * @author Niatomi
 */
public class Generator implements Generatable {    

    @Override
    public void generate(ArtistDAO dao) {
        dao.insert(new Artist("Metallica"));
        dao.insert(new Artist("Pink Floyd"));
        dao.insert(new Artist("Megadeth"));
        dao.insert(new Artist("Gojira"));
        dao.insert(new Artist("Plini"));
        dao.insert(new Artist("Dream Theather"));
    }

    @Override
    public void generate(GenreDAO dao) {
        dao.insert(new Genre("Metal"));
        dao.insert(new Genre("Rock"));
        dao.insert(new Genre("Death-Metal"));
        dao.insert(new Genre("Prog"));
    }

    @Override
    public void generate(SongDAO dao) {
        dao.insert(new Song("One", 1, 1, 0));
        dao.insert(new Song("Master of Puppets", 1, 1, 10));
        dao.insert(new Song("Money", 2, 4, 64));
        dao.insert(new Song("Dystopia", 3, 1, 130));
        dao.insert(new Song("Peace Sells", 3, 1, 142));
        dao.insert(new Song("Stranded", 4, 3, 90));
        dao.insert(new Song("New Found", 4, 3, 90));
        dao.insert(new Song("Inhale", 5, 4, 145));
        dao.insert(new Song("Electic Sunrises", 5, 4, 145));
        dao.insert(new Song("The Dance of Eternity", 6, 4, 12));
    }

    @Override
    public void generate(PlaylistDAO dao) {
        List<Integer> metal = new ArrayList<>();
        List<Integer> prog = new ArrayList<>();
        List<Integer> death = new ArrayList<>();
        metal.add(10000000);
        metal.add(10000001);
        metal.add(10000003);
        metal.add(10000004);
        prog.add(10000002);
        prog.add(10000007);
        prog.add(10000008);
        prog.add(10000009);
        death.add(10000006);
        death.add(10000005);
        dao.insert(new Playlist("Metal", metal, 10));
        dao.insert(new Playlist("Progressive", prog, 10));
        dao.insert(new Playlist("Death-Metal", death, 10));
    }
    
}
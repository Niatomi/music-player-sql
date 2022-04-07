package ru.niatomi.generator.impl;

import ru.niatomi.dao.impl.ArtistDAO;
import ru.niatomi.dao.impl.GenreDAO;
import ru.niatomi.dao.impl.PlaylistDAO;
import ru.niatomi.dao.impl.SongDAO;
import ru.niatomi.generator.Generatable;

/**
 * @author Niatomi
 */
public class GeneratorImpl implements Generatable {
    @Override
    public void generate(ArtistDAO dao) {

    }

    @Override
    public void generate(GenreDAO dao) {

    }

    @Override
    public void generate(SongDAO dao) {

    }

    @Override
    public void generate(PlaylistDAO dao) {

    }

//    @Override
//    public void generate(ArtistDAO dao) {
//        dao.insert(new Artist("Metallica"));
//        dao.insert(new Artist("Pink Floyd"));
//        dao.insert(new Artist("Megadeth"));
//        dao.insert(new Artist("Gojira"));
//        dao.insert(new Artist("Plini"));
//        dao.insert(new Artist("Dream Theather"));
//    }
//
//    @Override
//    public void generate(GenreDAO dao) {
//        dao.insert(new Genre("Metal"));
//        dao.insert(new Genre("Rock"));
//        dao.insert(new Genre("Death-Metal"));
//        dao.insert(new Genre("Prog"));
//    }
//
//    @Override
//    public void generate(SongDAO dao) {
//        dao.insert(new Song("One", 1, 1, 0));
//        dao.insert(new Song("Master of Puppets", 1, 1, 10));
//        dao.insert(new Song("Money", 2, 4, 64));
//        dao.insert(new Song("Dystopia", 3, 1, 130));
//        dao.insert(new Song("Peace Sells", 3, 1, 142));
//        dao.insert(new Song("Stranded", 4, 3, 90));
//        dao.insert(new Song("New Found", 4, 3, 90));
//        dao.insert(new Song("Inhale", 5, 4, 145));
//        dao.insert(new Song("Electic Sunrises", 5, 4, 145));
//        dao.insert(new Song("The Dance of Eternity", 6, 4, 12));
//    }
//
//    @Override
//    public void generate(PlaylistDAO dao) {
//        List<Integer> metal = new ArrayList<>();
//        List<Integer> prog = new ArrayList<>();
//        List<Integer> death = new ArrayList<>();
//        metal.add(10000000);
//        metal.add(10000001);
//        metal.add(10000003);
//        metal.add(10000004);
//        prog.add(10000002);
//        prog.add(10000007);
//        prog.add(10000008);
//        prog.add(10000009);
//        death.add(10000006);
//        death.add(10000005);
//        dao.insert(new Playlist("Metal", metal, 10));
//        dao.insert(new Playlist("Progressive", prog, 10));
//        dao.insert(new Playlist("Death-Metal", death, 10));
//    }
    
}

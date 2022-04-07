package ru.niatomi.generator;

import ru.niatomi.dao.impl.ArtistDAO;
import ru.niatomi.dao.impl.GenreDAO;
import ru.niatomi.dao.impl.PlaylistDAO;
import ru.niatomi.dao.impl.SongDAO;

/**
 * @author Niatomi
 */
public interface Generatable {
    
    /**
     * Создание набора данных для класса Artist.
     * @return 
     */
    void generate(ArtistDAO dao);
    
    /**
     * Создание набора данных для класса Genre.
     * @return 
     */
    void generate(GenreDAO dao);
    
    /**
     * Создание набора данных для класса ru.niatomi.Substanses.impl.Song.
     * @return 
     */
    void generate(SongDAO dao);
    
    /**
     * Создание набора данных для класса Playlist.
     * @return 
     */
    void generate(PlaylistDAO dao);
    
    
}

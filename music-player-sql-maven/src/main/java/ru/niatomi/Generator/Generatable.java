/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.Generator;

import musicplayersql.Classes.Generics.ArtistDAO;
import musicplayersql.Classes.Generics.GenreDAO;
import musicplayersql.Classes.Generics.PlaylistDAO;
import musicplayersql.Classes.Generics.SongDAO;

/**
 *
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
     * Создание набора данных для класса Song.
     * @return 
     */
    void generate(SongDAO dao);
    
    /**
     * Создание набора данных для класса Playlist.
     * @return 
     */
    void generate(PlaylistDAO dao);
    
    
}

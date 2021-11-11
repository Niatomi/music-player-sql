/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayersql.Classes.VIEW;

import musicplayersql.Classes.Generics.ArtistDAO;
import musicplayersql.Classes.Generics.GenreDAO;
import musicplayersql.Classes.Generics.SongDAO;

/**
 *
 * @author Niatomi
 */
public interface Viewable {
    
    /**
     * Создание представления объединяющее Song, Artist, Genre.
     * @return 
     */
    void song_view();
    
    /**
     * Создание представления объединяющее Plalist_Songs, Song_View.
     * @return 
     */
    void playlist_song_view();
}

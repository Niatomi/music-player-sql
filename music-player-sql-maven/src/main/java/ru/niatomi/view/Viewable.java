package ru.niatomi.view;

/**
 * @author Niatomi
 */
public interface Viewable {
    
    /**
     * Создание представления объединяющее ru.niatomi.Substanses.impl.Song, Artist, Genre.
     * @return 
     */
    void songView();
    
    /**
     * Создание представления объединяющее Plalist_Songs, Song_View.
     * @return 
     */
    void playlistSongView();
}

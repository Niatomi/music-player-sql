package ru.niatomi.view;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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

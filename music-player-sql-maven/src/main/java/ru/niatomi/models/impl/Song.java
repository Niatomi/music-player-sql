package ru.niatomi.models.impl;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.models.Playable;

/**
 *
 * @author Niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Playable {
    
    private int id;
    private String name;
    private int auditions;
    private Artist artist;
    private Genre genre;

    @Override
    public void play() {
       this.auditions = auditions + 1;
    }
    
}

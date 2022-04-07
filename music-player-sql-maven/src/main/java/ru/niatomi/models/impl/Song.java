package ru.niatomi.models.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.models.Playable;

/**
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

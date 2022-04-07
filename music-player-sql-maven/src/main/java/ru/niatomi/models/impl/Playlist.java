package ru.niatomi.models.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.models.Playable;

import java.util.List;

/**
 *
 * @author Niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist implements Playable {
    private int id;
    private String name;
    private List<Song> songs;
    private int auditions;

    @Override
    public void play() {
        songs.forEach(song -> song.play());
    }


}

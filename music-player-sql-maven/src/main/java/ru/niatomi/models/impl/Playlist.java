package ru.niatomi.models.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.niatomi.models.Playable;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Set;

/**
 * @author Niatomi
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "playlist")
public class Playlist implements Playable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 30, unique = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song songs;

    @Override
    public void play() {
//        songs.forEach(song -> song.play());
    }
}

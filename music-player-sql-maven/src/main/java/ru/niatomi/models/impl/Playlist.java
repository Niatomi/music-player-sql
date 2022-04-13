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

    @Column(name = "name", nullable = false, length = 30, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song songs;

    @Column(name = "auditions")
    @Positive
    private int auditions;

    @Override
    public void play() {
//        songs.forEach(song -> song.play());
    }

    private static final String CREATE_1 ="CREATE TABLE PLAYLIST (" +
            " ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1000, INCREMENT BY 1)," +
            " NAME VARCHAR(30) NOT NULL," +
            " AUDITIONS INTEGER," +
            " PRIMARY KEY (ID)," +
            " UNIQUE(NAME)," +
            " CONSTRAINT CK_PLAYLIST_AUDITIONS CHECK(AUDITIONS>=0)" +
            " )";

    private static final String CREATE_2 ="CREATE TABLE PLAYLIST_SONGS (" +
            " ID INT GENERATED ALWAYS AS IDENTITY," +
            " PLAYLIST_ID INTEGER," +
            " SONG_ID INTEGER," +
            " CONSTRAINT UQ_SONG_ID UNIQUE(SONG_ID)," +
            " CONSTRAINT FK_PLAYLIST_ID FOREIGN KEY(PLAYLIST_ID) REFERENCES PLAYLIST(ID)," +
            " CONSTRAINT FK_SONG_ID FOREIGN KEY(SONG_ID) REFERENCES SONG(ID)," +
            " PRIMARY KEY (ID)" +
            " )";


}

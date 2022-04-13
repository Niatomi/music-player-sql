package ru.niatomi.models.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.niatomi.models.Playable;

import javax.persistence.*;
import javax.validation.constraints.Positive;

/**
 * @author Niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song implements Playable {

    private static final String CREATE ="CREATE TABLE SONG(" +


            " CONSTRAINT PK_SONG_ID PRIMARY KEY(ID)," +
            " CONSTRAINT FK_SONG_ARTIST_ID FOREIGN KEY(ARTIST_ID) REFERENCES" +
            " ARTIST(ID)," +
            " CONSTRAINT FK_SONG_GENRE_ID FOREIGN KEY(GENRE_ID) REFERENCES" +
            " GENRE(ID)," +
            " CONSTRAINT CK_SONG_AUDITIONS CHECK(AUDITIONS >= 0)" +
            ")";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private int id;

    @Column(length = 30)
    private String name;

    @Column(name = "auditions")
    @Positive
    private int auditions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @Override
    public void play() {
       this.auditions = auditions + 1;
    }
    
}

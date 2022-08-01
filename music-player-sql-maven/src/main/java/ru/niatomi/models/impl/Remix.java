package ru.niatomi.models.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "remix")
public class Remix extends Song {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Song originalSong;

    @Column(name = "is_remix", nullable = false)
    private boolean isRemix;

}

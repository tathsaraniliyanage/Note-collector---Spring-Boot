package lk.ijse.gdse.aad68.NoteCollectorV2.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.aad68.NoteCollectorV2.entity.SuperEntity;
import lk.ijse.gdse.aad68.NoteCollectorV2.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;
}
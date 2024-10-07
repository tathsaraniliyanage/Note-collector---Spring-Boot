package lk.ijse.gdse.aad68.NoteCollectorV2.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.aad68.NoteCollectorV2.entity.NoteEntity;
import lk.ijse.gdse.aad68.NoteCollectorV2.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
}
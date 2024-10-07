package lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl;

import lk.ijse.gdse.aad68.NoteCollectorV2.CustomObj.NoteResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
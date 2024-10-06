package lk.ijse.gdse.aad68.NoteCollectorV2.CustomObj;

import lk.ijse.gdse.aad68.NoteCollectorV2.CustomObj.NoteResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteErrorResponse implements NoteResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
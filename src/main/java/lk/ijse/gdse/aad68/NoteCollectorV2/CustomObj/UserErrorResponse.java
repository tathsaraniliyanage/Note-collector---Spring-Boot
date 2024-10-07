package lk.ijse.gdse.aad68.NoteCollectorV2.CustomObj;

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
public class UserErrorResponse implements UserResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
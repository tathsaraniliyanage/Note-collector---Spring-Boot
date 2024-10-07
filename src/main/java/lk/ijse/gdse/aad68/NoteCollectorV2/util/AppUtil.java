package lk.ijse.gdse.aad68.NoteCollectorV2.util;

import java.util.Base64;
import java.util.UUID;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

public class AppUtil {

    public static String createNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }
    public static String createUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String toBase64ProfilePic(String profilePic){
        return Base64.getEncoder().encodeToString(profilePic.getBytes());
    }
}
package lk.ijse.gdse.aad68.NoteCollectorV2.controller;


import lk.ijse.gdse.aad68.NoteCollectorV2.CustomObj.UserResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.NoteCollectorV2.exception.UserNotFoundException;
import lk.ijse.gdse.aad68.NoteCollectorV2.service.UserService;
import lk.ijse.gdse.aad68.NoteCollectorV2.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;
    //Save User
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilePic") MultipartFile profilePic) {

        // Handle profile pic
        try {
//            byte[] imageByteCollection= profilePic.getBytes();

            String base64ProfilePic = AppUtil.toBase64ProfilePic(String.valueOf(profilePic));
            // build the user object
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePic(base64ProfilePic);
            //send to the service layer
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ("id") String userId){
//       return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getSelectedUser(@PathVariable ("id") String userId){
        return userService.getSelectedUser(userId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable ("id") String id,
                                           @RequestPart("updateFirstName") String updateFirstName,
                                           @RequestPart ("updateLastName") String updateLastName,
                                           @RequestPart ("updateEmail") String updateEmail,
                                           @RequestPart ("updatePassword") String updatePassword,
                                           @RequestPart ("updateProfilePic") MultipartFile updateProfilePic){
        try {
            String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(String.valueOf(updateProfilePic));
            var updateUser = new UserDTO();
            updateUser.setUserId(id);
            updateUser.setFirstName(updateFirstName);
            updateUser.setLastName(updateLastName);
            updateUser.setPassword(updatePassword);
            updateUser.setEmail(updateEmail);
            updateUser.setProfilePic(updateBase64ProfilePic);
            userService.updateUser(updateUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }

}
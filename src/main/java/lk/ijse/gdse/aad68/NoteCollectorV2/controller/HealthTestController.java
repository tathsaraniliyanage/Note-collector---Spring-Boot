package lk.ijse.gdse.aad68.NoteCollectorV2.controller;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/healthtest")
public class HealthTestController {
    @GetMapping
    public String healthTest(){
        return "Note collector app run successfully";
    }
}
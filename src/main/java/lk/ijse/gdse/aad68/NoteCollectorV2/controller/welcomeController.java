package lk.ijse.gdse.aad68.NoteCollectorV2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prabodha Thathsarani
 * @date 10/6/24
 * @project NoteCollectorV2
 **/

//apita view ekk eliyt gnn pluwn controller ekkin withri.rest controller ekkin be.server side pages hadaddi api danne controllers we.
@Controller
@RequestMapping("api/v1/welcome")
public class welcomeController {
    @GetMapping
    public String welcome(Model model){
        model.addAttribute("message","welcome to NoteController");
        return "welcome";
    }
}

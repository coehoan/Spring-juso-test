package site.metacoding.jusotest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JusoTestController {

    @GetMapping("/")
    public String test() {
        return "/joinForm";
    }

    @GetMapping("/popUp")
    public String popUp() {
        return "/jusoPopup";
    }

    @PostMapping("/popUp")
    public String popUpCallback(String inputYn, String zipNo, String roadFullAddr, Model model) {
        model.addAttribute("inputYn", inputYn);
        model.addAttribute("zipNo", zipNo);
        model.addAttribute("roadFullAddr", roadFullAddr);
        return "/jusoPopup";
    }
}

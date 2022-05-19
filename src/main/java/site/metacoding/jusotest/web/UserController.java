package site.metacoding.jusotest.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.jusotest.service.UserService;
import site.metacoding.jusotest.web.dto.JoinReqDTO;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String main() {
        return "/main";
    }

    @GetMapping("/joinform")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/popUp")
    public String popUp() {
        return "/user/jusoPopup";
    }

    @PostMapping("/popUp")
    public String popUpCallback(String inputYn, String zipNo, String roadFullAddr, Model model) {
        model.addAttribute("inputYn", inputYn);
        model.addAttribute("zipNo", zipNo);
        model.addAttribute("roadFullAddr", roadFullAddr);
        return "/user/jusoPopup";
    }

    @PostMapping("/join")
    public String join(JoinReqDTO joinReqDTO) {
        userService.회원가입(joinReqDTO.toEntity());
        return "/loginForm";
    }
}

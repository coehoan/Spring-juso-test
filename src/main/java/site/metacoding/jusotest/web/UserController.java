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

    // 페인페이지
    @GetMapping("/")
    public String main() {
        return "/main";
    }

    // 회원가입 페이지
    @GetMapping("/joinform")
    public String joinForm() {
        return "/user/joinForm";
    }

    // 로그인 페이지
    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    // 도로명주소 검색창 띄우기
    @GetMapping("/popUp")
    public String popUp() {
        return "/user/jusoPopup";
    }

    // 도로명주소 검색결과 반영하기
    @PostMapping("/popUp")
    public String popUpCallback(String inputYn, String zipNo, String roadFullAddr, Model model) {
        model.addAttribute("inputYn", inputYn);
        model.addAttribute("zipNo", zipNo);
        model.addAttribute("roadFullAddr", roadFullAddr);
        return "/user/jusoPopup";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(JoinReqDTO joinReqDTO) {
        userService.회원가입(joinReqDTO.toEntity());
        return "redirect:/loginForm";
    }
}

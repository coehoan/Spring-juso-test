package site.metacoding.jusotest.web;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.jusotest.domain.User;
import site.metacoding.jusotest.service.UserService;
import site.metacoding.jusotest.web.dto.JoinReqDTO;
import site.metacoding.jusotest.web.dto.PasswordUpdateReqDto;
import site.metacoding.jusotest.web.dto.UpdateReqDTO;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // 메인페이지
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

    // 마이페이지
    @GetMapping("/s/user/{id}/detail")
    public String detailForm(@PathVariable Integer id, Model model) {
        User userEntity = userService.마이페이지(id);
        model.addAttribute("user", userEntity);
        return "/user/detailForm";
    }

    // 도로명주소 검색창 띄우기
    @GetMapping("/popUp")
    public String popUp() {
        return "/user/jusoPopup";
    }

    // 비밀번호 변경 검색창 띄우기
    @GetMapping("/passwordPopup")
    public String passwordPopup() {
        return "/user/passwordPopup";
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

    // 로그아웃
    @GetMapping("/s/logout")
    public String logout() {
        session.invalidate();
        return "/";
    }

    // 회원정보 수정
    @PutMapping("/s/user/{id}/update")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateReqDTO updateReqDTO) {
        User userEntity = userService.회원정보수정(id, updateReqDTO);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    // 비밀번호 수정
    @PutMapping("/s/user/{id}/passwordUpdate")
    public ResponseEntity<?> passwordUpdate(@PathVariable Integer id,
            @RequestBody PasswordUpdateReqDto passwordUpdateReqDto) {
        User userEntity = userService.비밀번호수정(id, passwordUpdateReqDto);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}

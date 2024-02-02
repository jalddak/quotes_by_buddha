package toy.buddha.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import toy.buddha.admin.domain.Admin;
import toy.buddha.admin.domain.SessionConst;
import toy.buddha.admin.dto.AdminLoginDto;
import toy.buddha.admin.service.LoginService;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("admin") AdminLoginDto adminLoginDto) {
        return "admin/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("admin") AdminLoginDto adminLoginDto, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/admin") String redirectURL, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "admin/loginForm";
        }

        Admin loginAdmin = loginService.login(adminLoginDto.getUsername(), adminLoginDto.getPassword());

        if (loginAdmin == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("errors={}", bindingResult);
            return "admin/loginForm";
        }

        // 로그인 성공 처리
        // 세션이 있으면 세션 반환, 세션이 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_ADMIN, loginAdmin);


        return "redirect:" + redirectURL;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/admin";
    }
}

package toy.buddha.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.buddha.admin.domain.Admin;
import toy.buddha.admin.domain.SessionConst;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminHome(@SessionAttribute(name = SessionConst.LOGIN_ADMIN, required = false) Admin admin,
                            Model model) {

        // 로그인
        if (admin == null) {
            return "admin/home";
        }

        model.addAttribute("admin", admin);
        return "admin/loginHome";
    }
}

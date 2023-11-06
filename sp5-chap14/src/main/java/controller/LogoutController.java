package controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutController {

    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}

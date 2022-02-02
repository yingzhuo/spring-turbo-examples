package spring.turbo.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.turbo.examples.service.LoginService;
import spring.turbo.module.security.user.CurrentUserUsername;
import spring.turbo.util.StringFormatter;

@RestController
@RequestMapping("security")
class SecurityController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    String token(@RequestParam("username") String username,
                 @RequestParam("password") String password) {
        return loginService.createToken(username, password);
    }

    @GetMapping("info")
    String info(@CurrentUserUsername String username) {
        return StringFormatter.format("{} 已经登录", username);
    }

}

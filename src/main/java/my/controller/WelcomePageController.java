package my.controller;

import my.database.service.AccountTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: Sushakov
 * Date: 12/28/2018
 * Time: 17:29
 **/
@Controller
public class WelcomePageController {

    private AccountTable account;

    public WelcomePageController(AccountTable account) {
        this.account = account;
    }

    @RequestMapping("/")
    public ModelAndView welcome(){
        return new ModelAndView("welcome");
    }

    @RequestMapping("/test")
    public String test(){
        account.insert("user", "user", false, 0);
        return "redirect:/";
    }

    @RequestMapping("/two")
    public String testMe() throws Exception {
        account.lock(21);
        return "redirect:/";
    }

}

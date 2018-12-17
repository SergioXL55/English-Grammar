package my.controller;

import my.encode.TextEncryptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * User: sushakov
 * Date: 11/20/2018
 * Time: 18:37
 **/
@Controller
@ComponentScan("my")
public class MainController {

    private TextEncryptor textEncryptor;

    public MainController(TextEncryptor textEncryptor) {
        this.textEncryptor = textEncryptor;
    }

    @RequestMapping(path = "/")
    public ModelAndView createAccount(ModelMap model) {
        model.addAttribute("perfix", "");
        model.addAttribute("title", "Spring Security");
        model.addAttribute("decode", "отсутствует");
        return new ModelAndView("generator", model);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ModelAndView getEncodingMessage(@RequestParam Map<String, String> param, ModelMap model) {
        model.addAttribute("perfix", "");
        model.addAttribute("title", "Spring Security");
        String encryptText = "Введено пустое значение!";
        if (param.get("text") != null) {
            encryptText = textEncryptor.encodeText(param.get("text"));
        }
        model.addAttribute("decode", encryptText);
        return new ModelAndView("generator", model);
    }


}

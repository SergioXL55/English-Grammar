package my.controller;

import my.encode.DecryptedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * User: Sushakov
 * Date: 12/26/2018
 * Time: 12:27
 **/
@Controller
public class EncryptorController {

    private DecryptedService decryptedService;

    public EncryptorController(DecryptedService decryptedService) {
        this.decryptedService = decryptedService;
    }

    @RequestMapping(path = "/security")
    public ModelAndView createAccount(ModelMap model) {
        model.addAttribute("title", "Spring Security");
        return new ModelAndView("generator", model);
    }

    @RequestMapping(path = "/encode", method = RequestMethod.POST, produces = {"application/text; charset=UTF-8"})
    @ResponseBody
    public String getEncodingMessage(@RequestParam Map<String, String> param) {
        String encryptText = "Введено пустое значение!!!!!";
        if (param.get("text") != null) {
            try {
                encryptText = decryptedService.encrypt(param.get("text"));
            } catch (Exception e) {
                if(e.getLocalizedMessage()!=null)
                    encryptText = e.getLocalizedMessage(); else encryptText="Encode error";
            }
        }
        return encryptText;
    }

    @RequestMapping(path = "/decode", method = RequestMethod.POST, produces = {"application/text; charset=UTF-8"})
    @ResponseBody
    public String getDecodingMessage(@RequestParam Map<String, String> param) {
        String decryptText = "Введено пустое значение!!!!!";
        if (param.get("text") != null) {
            try {
                decryptText = decryptedService.decrypt(param.get("text"));
            } catch (Exception e) {
                if(e.getLocalizedMessage()!=null)
                    decryptText = e.getLocalizedMessage(); else decryptText="Decode error";
            }
        }
        return decryptText;
    }
}

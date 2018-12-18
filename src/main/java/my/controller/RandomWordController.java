package my.controller;

import my.words.scentence.RandomSentence;
import my.words.translate.Translator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * User: sushakov
 * Date: 12/11/2018
 * Time: 15:53
 **/
@Controller
public class RandomWordController {

    private final static int SENTENCES_COUNT = 5;
    private RandomSentence randomSentence;
    private Translator translator;

    public RandomWordController(RandomSentence randomSentence, Translator translator) {
        this.randomSentence = randomSentence;
        this.translator = translator;
    }

    @RequestMapping("/word")
    public ModelAndView loadRandomWord(@RequestParam Map<String, String> param, ModelMap modelMap) {
        randomSentence.clearScentences();
        randomSentence.addSentencesFromWeb(SENTENCES_COUNT);
        modelMap.addAttribute("sentences", randomSentence.getAllSecntences());
        return new ModelAndView("wordView", modelMap);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Integer randomWord(@RequestParam Map<String, String> param, ModelMap modelMap) {
        int id = Integer.parseInt(param.getOrDefault("id", "0"));
        int num = Integer.parseInt(param.getOrDefault("num", "0"));
        return randomSentence.checkWord(id, num).getCode();
    }

    @RequestMapping(value = "/trans", method = RequestMethod.POST, produces = {"application/text; charset=UTF-8"})
    @ResponseBody
    public String translateWord(@RequestParam Map<String, String> param) {
        return translator.getTranslate(param.getOrDefault("text", "error"));
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Integer test(@RequestParam Map<String, String> param) {
        return randomSentence.checkWord(0, 0).getCode();
    }
}

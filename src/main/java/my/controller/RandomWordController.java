package my.controller;

import my.words.RandomSentence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    public RandomWordController(RandomSentence randomSentence) {
        this.randomSentence = randomSentence;
    }

    @RequestMapping("/word")
    public ModelAndView loadRandomWord(@RequestParam Map<String, String> param, ModelMap modelMap) {
        randomSentence.clearScentences();
        randomSentence.addSentencesFromWeb(SENTENCES_COUNT);
        modelMap.addAttribute("sentence", randomSentence.getAllSecntences());
        return new ModelAndView("wordView", modelMap);
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView randomWord(@RequestParam Map<String, String> param, ModelMap modelMap) {
        int id = Integer.parseInt(param.getOrDefault("id", "0"));
        int num = Integer.parseInt(param.getOrDefault("num", "0"));
        modelMap.addAttribute("answer", randomSentence.checkWord(id, num).getCode());
        return new ModelAndView("answer", modelMap);
    }

}

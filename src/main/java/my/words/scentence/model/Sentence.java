package my.words.scentence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: sushakov
 * Date: 12/11/2018
 * Time: 16:05
 **/

public class Sentence implements Serializable {

    private List<String> sentence = new ArrayList<>();
    private Map<Integer, Integer> realMap = new HashMap<>();
    private List<String> randomSentence = new ArrayList<>();
    private List<String> translatedSentence = new ArrayList<>();
    private Integer currentPosition = 0;
    private boolean finished = false;

    public Sentence() {

    }

    public List<String> getSentence() {
        return sentence;
    }

    public void setSentence(List<String> sentence) {
        this.sentence = sentence;
    }

    public Map<Integer, Integer> getRealMap() {
        return realMap;
    }

    public void setRealMap(Map<Integer, Integer> realMap) {
        this.realMap = realMap;
    }

    public List<String> getRandomSentence() {
        return randomSentence;
    }

    public void setRandomSentence(List<String> randomSentence) {
        this.randomSentence = randomSentence;
    }

    public List<String> getTranslatedSentence() {
        return translatedSentence;
    }

    public void setTranslatedSentence(List<String> translatedSentence) {
        this.translatedSentence = translatedSentence;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

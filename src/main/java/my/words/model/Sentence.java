package my.words.model;

import my.words.answer.AnswerCode;

import java.util.*;

/**
 * User: sushakov
 * Date: 12/11/2018
 * Time: 16:05
 **/

public class Sentence {

    private List<String> sentence = new ArrayList<>();
    private Map<Integer, Integer> realMap = new HashMap<>();
    private List<String> randomSentence = new ArrayList<>();
    private Integer currentPosition = 0;
    private boolean finished = false;
    private final static String DELIMITER = " ";

    public Sentence() {

    }

    public Sentence(String sentence, boolean usedelimiter) {
        if (usedelimiter) setSentence(sentence.split(DELIMITER));
        else setSentence(sentence);
    }

    private void setSentence(String... word) {
        sentence.addAll(Arrays.asList(word));
        for (int i = 0; i < sentence.size(); i++) {
            realMap.put(getRandomPosition(), i);
        }
        currentPosition = 0;
        setRandomSentence();
    }

    private Integer getRandomPosition() {
        Random random = new Random();
        Integer key = random.nextInt(sentence.size());
        while (realMap.containsKey(key)) {
            key = random.nextInt(sentence.size());
        }
        return key;
    }

    private void setRandomSentence() {
        realMap.forEach((k, v) -> randomSentence.add(sentence.get(v)));
    }

    public List<String> getRandomSentence() {
        return randomSentence;
    }

    public AnswerCode checkWord(int wordPosition) {
        if (!finished) {
            if (realMap.get(wordPosition).equals(currentPosition)) {
                currentPosition++;
                if (currentPosition == sentence.size()) {
                    finished = true;
                    return AnswerCode.CODE_FINISH;
                }
                return AnswerCode.CODE_OK;
            }
        }
        return AnswerCode.CODE_NO;
    }
}

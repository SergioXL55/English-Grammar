package my.words.scentence.impl;

import my.words.answer.AnswerCode;
import my.words.news.RandomTitle;
import my.words.scentence.RandomSentence;
import my.words.scentence.model.Sentence;
import my.words.scentence.template.SentenceTemplate;
import my.words.translate.Translator;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * User: sushakov
 * Date: 12/11/2018
 * Time: 15:54
 **/

@Configuration
public class RandomSentenceImpl extends SentenceTemplate implements RandomSentence {

    private List<Sentence> sentences = new ArrayList<>();
    private Sentence currentSentence;

    private RandomTitle randomTitle;
    private Translator translator;

    public RandomSentenceImpl(RandomTitle googleNews, Translator yandexTranslator) {
        this.translator = yandexTranslator;
        this.randomTitle = googleNews;
    }

    @Override
    protected Sentence findSentence(int number) {
        return sentences.get(number);
    }

    @Override
    public AnswerCode checkWord(int sentencePos, int wordPos) {
        Sentence curSentence = findSentence(sentencePos);
        if (!curSentence.isFinished()) {
            if (curSentence.getRealMap().get(wordPos).equals(curSentence.getCurrentPosition())) {
                curSentence.setCurrentPosition(curSentence.getCurrentPosition() + 1);//TODO колхоз едишн
                if (curSentence.getCurrentPosition() == curSentence.getSentence().size()) {
                    curSentence.setFinished(true);
                    return AnswerCode.FINISH;
                }
                return AnswerCode.OK;
            }
        }
        return AnswerCode.NO;
    }

    @Override
    public List<Sentence> getAllSecntences() {
        return sentences;
    }


    @Override
    public void clearScentences() {
        if (sentences != null) sentences.clear();
    }

    @Override
    public void addSentencesFromWeb(int sentenceCount) {
        for (int i = 0; i < sentenceCount; i++) {
            addSentence(randomTitle.getTitle());
        }
    }

    @Override
    protected void addSentence(String sentence) {
        currentSentence = new Sentence();
        currentSentence.getSentence().addAll(Arrays.asList(sentence.split(DELIMITER)));
        for (int i = 0; i < currentSentence.getSentence().size(); i++) {
            currentSentence.getRealMap().put(getRandomPosition(), i);
        }
        currentSentence.setCurrentPosition(0);
        addRandomSentence();
        sentences.add(currentSentence);
    }

    private Integer getRandomPosition() {
        int size = currentSentence.getSentence().size();
        Random random = new Random();
        Integer key = random.nextInt(size);
        while (currentSentence.getRealMap().containsKey(key)) {
            key = random.nextInt(size);
        }
        return key;
    }

    @Override
    protected void addRandomSentence() {
        currentSentence.getRealMap().forEach((k, v) -> currentSentence.getRandomSentence().add(currentSentence.getSentence().get(v)));
    }

}

package my.words;

import my.words.answer.AnswerCode;
import my.words.model.Sentence;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * User: sushakov
 * Date: 12/11/2018
 * Time: 15:54
 **/

@Configuration
public class RandomSentenceImpl implements RandomSentence {

    private List<Sentence> sentences = new ArrayList<>();
    private RandomTitle randomTitle;

    public RandomSentenceImpl(RandomTitle googleNews) {
        this.randomTitle = googleNews;
    }

    @Override
    public AnswerCode checkWord(int sentencePos, int wordPos) {
        return sentences.get(sentencePos).checkWord(wordPos);
    }

    @Override
    public List<Sentence> getAllSecntences() {
        return sentences;
    }


    @Override
    public void addSentence(String sentence, boolean useDelimiter) {
        if (sentence != null && !sentence.isEmpty())
            sentences.add(new Sentence(sentence, useDelimiter));
    }

    @Override
    public void clearScentences() {
        if (sentences != null) sentences.clear();
    }

    @Override
    public void addSentencesFromWeb(int sentenceCount) {
        for (int i = 0; i < sentenceCount; i++) {
            addSentence(randomTitle.getTitle(), true);
        }
    }
}

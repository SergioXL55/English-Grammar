package my.words;

import my.words.answer.AnswerCode;
import my.words.model.Sentence;
import java.util.List;

/**
 * User: sushakov
 * Date: 12/12/2018
 * Time: 11:23
 **/


public interface RandomSentence {

    List<Sentence> getAllSecntences();

    void addSentencesFromWeb(int sentenceCount);

    void addSentence(String sentence, boolean useDelimiter);

    void clearScentences();

    AnswerCode checkWord(int sentencePos, int wordPos);


}

package my.words.scentence.template;

import my.words.scentence.model.Sentence;

/**
 * User: Sushakov
 * Date: 12/17/2018
 * Time: 14:40
 **/

abstract public class SentenceTemplate {

    protected final static String DELIMITER = " ";

    protected abstract void addSentence(String sentence);

    protected abstract Sentence findSentence(int number);

    protected abstract void addRandomSentence();

}

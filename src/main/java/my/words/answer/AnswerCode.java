package my.words.answer;

/**
 * User: Sushakov
 * Date: 12/13/2018
 * Time: 10:38
 **/

public enum AnswerCode {

    CODE_OK(1),
    CODE_NO(-1),
    CODE_FINISH(0);

    private int code;

    AnswerCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}

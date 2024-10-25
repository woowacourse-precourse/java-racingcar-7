package racingcar.util;

public enum Message {
    ERROR_TAG("[ERROR]"),
    BLANK(""),
    WHITE_SPACE(" "),
    ;

    String sentence;

    Message(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}

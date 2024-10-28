package racingcar.util;

public enum Message {
    ERROR_TAG("[ERROR]"),
    BLANK(""),
    WHITE_SPACE(" "),
    COMMA(","),
    RECEIVE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    RECEIVE_PLAY_COUNT("시도할 횟수는 몇 회인가요?"),
    COLON_WITH_SPACE(" : "),
    POSITION_DASH("-"),
    FINAL_WINNER("최종 우승자"),
    ;

    String sentence;

    Message(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}

package racingcar.enums;

import java.text.MessageFormat;

public enum ViewMessage {

    // Input
    PROMPT_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    PROMPT_PLAY_TIMES("시도할 횟수는 몇 회인가요?"),

    // Output
    PRINT_BLANK("\n"),
    PRINT_RESULT("실행 결과"),
    PRINT_WINNERS("최종 우승자 : {0}"),
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}

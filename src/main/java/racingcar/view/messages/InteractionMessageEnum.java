package racingcar.view.messages;

public enum InteractionMessageEnum {
    CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    COLON(" : "),
    HYPHEN("-"),
    WINNERS_MESSAGE("최종 우승자"),
    COMMA(", ");

    private final String message;

    InteractionMessageEnum(String message) {
        this.message = message;
    }

    // TODO: getter vs. 직접 사용??
    public String getInteractionMessage() {
        return message;
    }
}

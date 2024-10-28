package message;

public enum Message {

    INPUT_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT("시도할 횟수는 몇 회인가요?"),
    ILLEGAL_ARGUMENT_ERROR("올바르지 않은 형식 입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

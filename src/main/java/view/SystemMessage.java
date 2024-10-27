package view;

public enum SystemMessage {
    SET_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요"),
    GET_TRY_NUMBER_MESSAGE("시도할 횟수를 입력하세요");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}

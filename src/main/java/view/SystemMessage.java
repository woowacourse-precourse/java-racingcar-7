package view;

public class SystemMessage {
    SET_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요");

    private final String message;
    SystemMessage(String message) {
        this.message = message;
    }

    public String print(){
        return message;

    }
}

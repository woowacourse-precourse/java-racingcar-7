package racingcar.enums;

/**
 * packageName    : racingcar.enums
 * fileName       : Message
 * author         : ehgur
 * date           : 2024-10-24
 * description    : Race 프로그램에서 출력메시지를 담당하는 Enum
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-24         ehgur            최초 생성
 */

public enum Message {

    INPUT_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_LAP_COUNT("시도할 횟수는 몇 회인가요?");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

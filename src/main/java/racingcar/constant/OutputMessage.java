package racingcar.constant;

import java.util.List;

import racingcar.dto.CarDto;

public enum OutputMessage {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)%n"),
    INPUT_TRY_COUNT("시도할 횟수는 몇 회인가요?%n"),
    ROUND_RESULT("%n실행 결과%n"),
    ROUND_RESULT_CAR("%s : %s%n"),
    FINAL_WINNER("최종 우승자 : %s"),
    NEW_LINE("%n"),
    ;

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message);
    }

    public String getMessage(CarDto car) {
        if (equals(ROUND_RESULT_CAR)) {
            return String.format(message, car.name(), "-".repeat(car.position()));
        }
        return String.format(message);
    }

    public String getMessage(List<String> winnerNames) {
        if (equals(FINAL_WINNER)) {
            return String.format(message, String.join(", ", winnerNames));
        }
        return String.format(message);
    }
}

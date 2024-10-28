package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static  final String ROUND_RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_POSITION_MARKER = "-";
    private static  final String POSITION_DISPLAY_FORMAT = "%s : %s%n";
    private static final String RESULT_MESSAGE_FORMAT = "최종 우승자 : %s%n";

    public void displayCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void displayTrialCountInputMessage() {
        System.out.println(TRIAL_COUNT_INPUT_MESSAGE);
    }

    public void displayRoundResultMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }

    public void displayCarPosition(Car car) {
        String position = CAR_POSITION_MARKER.repeat(car.getPosition());
        System.out.printf(POSITION_DISPLAY_FORMAT, car.getName(), position);
    }

    public void displayRaceResult(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.printf(RESULT_MESSAGE_FORMAT, String.join(", ", winnerNames));
    }
}

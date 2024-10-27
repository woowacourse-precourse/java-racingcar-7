package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void displayCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void displayAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
    }

    public void displayResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append("-");
            }
            System.out.println(car.getName() + " : " + stringBuilder);
        }
        System.out.println();
    }

    public void displayWinner(List<String> winners) {
        String winnersName = String.join(", ", winners);
        System.out.println(WINNER_MESSAGE + winnersName);
    }
}

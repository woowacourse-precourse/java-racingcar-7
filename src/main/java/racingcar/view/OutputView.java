package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구준";
    private final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private final String FINAL_WINNER_MESSAGE = "최종 우승자";
    private final String POSITION_MARKER = "-";

    public void inputCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
    }

    public void displayExecutionResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void displayRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateDashes(car.getPosition()));
        }
        System.out.println();
    }

    public void displayWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(FINAL_WINNER_MESSAGE + " : " + winnerNames);
    }

    private String generateDashes(int position) {
        return POSITION_MARKER.repeat(Math.max(0, position));
    }

}

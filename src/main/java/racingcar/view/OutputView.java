package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    // 상수 필드로 메시지를 캡슐화
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String SEPARATOR = ", ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + String.join(SEPARATOR, winners));
    }
}

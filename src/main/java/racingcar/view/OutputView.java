package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class OutputView {

    private final String RESULT_MSG = "실행 결과";
    private final String WINNERS_MSG = "최종 우승자 : ";

    public void outputResultMessage() {
        System.out.println(RESULT_MSG);
    }

    public void outputOneRoundResult(List<Car> cars) {
        if (cars == null) {
            throw new IllegalAccessError("차 리스트는 null일 수 없습니다.");
        }
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void outputWinners(List<String> winners) {
        if (winners == null) {
            throw new IllegalArgumentException("최종 우승자는 null일 수 없습니다.");
        }
        System.out.println(WINNERS_MSG + String.join(", ", winners));
    }
}

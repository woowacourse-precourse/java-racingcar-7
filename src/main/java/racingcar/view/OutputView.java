package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    private static final String ROUND_RESULT_TITLE = "실행 결과";
    private static final String FINAL_WINNERS = "최종 우승자 : ";

    public void printRoundResult(List<Car> cars) {
        System.out.println(ROUND_RESULT_TITLE);
        for (Car car : cars) {
            String displayRoundResult = car.getName() + " : " + "-".repeat(car.getPosition());
            System.out.println(displayRoundResult);
        }
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println(FINAL_WINNERS + finalWinners);
    }
}

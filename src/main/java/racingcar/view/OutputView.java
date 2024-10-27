package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    public void printRoundResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            String displayRoundResult = car.getName() + " : " + "-".repeat(car.getPosition());
            System.out.println(displayRoundResult);
        }
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        String finalWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + finalWinners);
    }

}

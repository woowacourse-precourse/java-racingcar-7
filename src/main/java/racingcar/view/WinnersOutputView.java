package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class WinnersOutputView {
    public void print(List<Car> winners) {
        String[] winnerArr = winners.stream()
                .map(Car::getName)
                .toArray(String[]::new);

        String winnersStr = String.join(", ", winnerArr);
        System.out.print("최종 우승자 : " + winnersStr);
    }
}

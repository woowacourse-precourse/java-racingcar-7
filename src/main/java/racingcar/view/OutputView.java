package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void outputWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        String content = String.join(",", winnerNames);
        System.out.println("최종 우승자 : " + content);
    }
}

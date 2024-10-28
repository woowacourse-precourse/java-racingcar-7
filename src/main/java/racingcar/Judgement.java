package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {
    public List<String> getWinners(List<Car> cars) {
        int maxMove = cars.stream().mapToInt(Car::getMoveCount).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMove)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void announceWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

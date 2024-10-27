package racingcar.domain.winner;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.delimiter.Delimiter;

public class Winner {

    public String getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        for (Car car : cars) {
            if (car.getMoveCount() == maxMoveCount) {
                winners.add(car.getName());
            }
        }

        return String.join(Delimiter.SPACE_COMMA.getDelimiter(), winners);
    }

}

package racingcar.domain.racing;

import java.util.List;
import racingcar.common.exception.EmptyCarsException;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.interfaces.winner.WinnerResponse;

public class JudgeService {

    public WinnerResponse judgeWinner(Cars cars) {
        int maxCarPosition = getMaxCarPosition(cars);
        List<Car> winner = getWinner(cars, maxCarPosition);

        return WinnerResponse.from(winner);
    }

    private int getMaxCarPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElseThrow(EmptyCarsException::new);
    }

    private List<Car> getWinner(Cars cars, int maxCarPosition) {
        return cars.getCars().stream()
                .filter(car -> car.getCarPosition() == maxCarPosition)
                .toList();
    }
}

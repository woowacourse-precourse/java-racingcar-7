package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public record GameService(List<Car> cars) {

    public void progress() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            CarService.forwardByRandomNumber(car, randomNumber);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

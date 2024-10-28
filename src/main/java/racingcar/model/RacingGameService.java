package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameService {
    List<CarDto> cars;


    public RacingGameService(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void gameStart() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                int index = cars.indexOf(car);
                CarDto movementCar = CarService.forwardMovement(car, car.getForward() + 1);
                cars.set(index, movementCar);
            }
        });
    }

    private void sortByForwardMovement() {
        cars.sort(Comparator.comparingInt(CarDto::getForward).reversed());
    }

    public List<CarDto> whoIsWinners() {
        List<CarDto> winners;
        sortByForwardMovement();
        int highScore = cars.getFirst().getForward();

        winners = cars.stream()
                      .filter(car -> car.getForward() == highScore)
                      .toList();

        return winners;
    }
}

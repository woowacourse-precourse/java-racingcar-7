package racingcar.domain.car;

import racingcar.domain.movement.RandomMovement;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars from(List<String> carNames){
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void playOneRound(RandomMovement randomMovement){
        cars.forEach(car -> car.go(randomMovement));
    }
}

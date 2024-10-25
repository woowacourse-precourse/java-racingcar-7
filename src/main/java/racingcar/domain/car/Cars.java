package racingcar.domain.car;

import racingcar.domain.movement.RandomMovement;
import racingcar.domain.race.RaceRoundRecord;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    //For test only
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playOneRound(RandomMovement randomMovement) {
        cars.forEach(car -> car.go(randomMovement));
    }

    public RaceRoundRecord getRaceRoundRecord() {
        return RaceRoundRecord.from(this);
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(cars -> cars.getDistance() == maxDistance)
                .collect(Collectors.toList());

    }

    private int getMaxDistance(){
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}

package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.CarStatusDto;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(getRandomMove()));
    }

    private int getRandomMove() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<CarStatusDto> submitCarsStatus() {
        return cars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .toList();
    }
}

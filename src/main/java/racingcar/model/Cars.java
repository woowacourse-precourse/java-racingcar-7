package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.enums.Move;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(getRandomMove()));
    }

    private int getRandomMove() {
        return Randoms.pickNumberInRange(Move.MIN_MOVING_RANGE.getMovement(), Move.MAX_MOVING_RANGE.getMovement());
    }

    public List<CarStatusDto> submitCarsStatus() {
        return cars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .toList();
    }
}

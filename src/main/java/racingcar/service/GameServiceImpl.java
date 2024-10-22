package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.utility.Calculator;

public class GameServiceImpl implements GameService {

    private final CarRepository carRepository;

    public GameServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void moveCarsRandomly() {
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            moveRandom(car);
        }
    }

    private void moveRandom(Car car) {
        if (Calculator.canMove(Randoms.pickNumberInRange(0, 9))) {
            car.move();
        }
    }
}

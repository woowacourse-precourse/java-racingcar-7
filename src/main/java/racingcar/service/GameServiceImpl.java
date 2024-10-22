package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.dto.GameResultDto;
import racingcar.repository.CarRepository;
import racingcar.utility.Calculator;

public class GameServiceImpl implements GameService {

    private final CarRepository carRepository;

    public GameServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
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

    @Override
    public GameResultDto getGameData() {
        Map<String, Integer> dataMap = new HashMap<>();
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            dataMap.put(car.getName(), car.getPosition());
        }
        return new GameResultDto(dataMap);
    }
}

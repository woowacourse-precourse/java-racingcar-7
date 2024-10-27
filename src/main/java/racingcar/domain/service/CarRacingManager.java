package racingcar.domain.service;

import racingcar.infrastructure.constant.Boundary;
import racingcar.domain.model.car.Car;
import racingcar.infrastructure.constant.CarConstants;
import racingcar.domain.util.CarNameParser;
import racingcar.domain.util.RandomNumberGenerator;
import racingcar.infrastructure.exception.EmptyInputException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRacingManager {
    private final Map<String, Car> cars = new HashMap<>();
    private final RandomNumberGenerator randomNumberGenerator;

    private CarRacingManager(List<Car> carList) {
        carList.forEach(car -> {
            cars.put(car.getName(), car);
        });
        randomNumberGenerator = new RandomNumberGenerator(Boundary.RANDOM_MIN, Boundary.RANDOM_MAX);
    }

    public static CarRacingManager from(final String input) {
        validateInput(input);
        List<String> parsed = CarNameParser.parse(input);
        List<Car> carList = parsed.stream()
                .map(Car::from)
                .toList();
        return new CarRacingManager(carList);
    }

    private static void validateInput(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new EmptyInputException();
        }
    }

    public void moveAllCar() {
        cars.keySet().forEach(name -> {
            if (canMove(randomNumberGenerator.pick())) {
                cars.get(name).moveForward();
            }
        });
    }

    private boolean canMove(final int number) {
        return number >= Boundary.MOVE_CONDITION_MIN;
    }

    public List<Car> getList() {
        return List.copyOf(cars.values());
    }

    // [삭제 예정] Test 코드에서만 사용
    // TODO: 해당 메소드 없이 테스트 구현하기
    public void moveForward(final String name) {
        cars.get(name).moveForward();
    }

    public String getWinners() {
        return getFirstPrizeCarList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(CarConstants.JOIN_DELIMITER));
    }

    private List<Car> getFirstPrizeCarList() {
        List<Car> ranked = getRankedCarList();
        final int maxDistance = ranked.getFirst().getDistance();
        return ranked.stream()
                .filter(c->c.getDistance() == maxDistance)
                .toList();
    }

    private List<Car> getRankedCarList() {
        return cars.values().stream()
                .sorted((a, b) -> b.getDistance() - a.getDistance())
                .toList();
    }
}

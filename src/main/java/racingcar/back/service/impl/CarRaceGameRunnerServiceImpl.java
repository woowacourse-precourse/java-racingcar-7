package racingcar.back.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import racingcar.back.domain.Car;
import racingcar.back.service.CarRaceGameRunnerService;
import racingcar.global.dto.CarRaceResponseDTO;
import racingcar.global.dto.CarRaceResult;

public class CarRaceGameRunnerServiceImpl implements CarRaceGameRunnerService {
    @Override
    public CarRaceResponseDTO runGame(List<String> gameNames, Integer gamePlayCount) {
        // 게임 실행 및 우승자 결정
        List<Car> cars = generateCars(gameNames);
        cars.forEach(car -> IntStream.range(0, gamePlayCount).forEach(i -> {
            car.moveIf(MoveConditionChecker.isMovable());
        }));
        setWinners(cars);

        List<CarRaceResult> carRaceResults = cars.stream().map(CarRaceResult::fromCar).toList();
        return new CarRaceResponseDTO(carRaceResults, gamePlayCount);
    }

    private static List<Car> generateCars(List<String> gameNames) {
        return gameNames.stream().map(Car::new).toList();
    }

    private void setWinners(List<Car> cars) {
        Integer maxMoveCount = cars.stream().mapToInt(Car::getMoveCount).max().orElseThrow(RuntimeException::new);
        cars.stream().filter(car -> Objects.equals(car.getMoveCount(), maxMoveCount)).forEach(Car::setWinner);
    }

}

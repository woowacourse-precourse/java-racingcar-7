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
        // 자동차 객체 생성
        List<Car> cars = gameNames.stream().map(Car::new).toList();
        // 게임 플레이
        cars.forEach(car -> IntStream.range(0, gamePlayCount).forEach(i -> {
            car.moveIf(MoveConditionChecker.isMovable());
        }));
        // 승자 결정
        Integer mavMoveCount = cars.stream().mapToInt(Car::getMoveCount).max().orElseThrow(RuntimeException::new);
        cars.stream().filter(car -> Objects.equals(car.getMoveCount(), mavMoveCount)).forEach(Car::setWinner);
        // 결과 및 실행 횟수 반환
        List<CarRaceResult> carRaceResults = cars.stream().map(CarRaceResult::fromCar).toList();
        return new CarRaceResponseDTO(carRaceResults, gamePlayCount);
    }

}

package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceResponse;
import racingcar.repository.CarRepository;

import java.util.*;

public class RaceService {

    private final CarRepository carRepository;

    public RaceService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public StartRaceResponse startRace(int attemptCount) {
        List<Car> cars = carRepository.getCars();
        List<Map<String, Integer>> moveData = getMoveData(attemptCount, cars);

        return new StartRaceResponse(moveData);
    }

    public GetWinnersResponse getWinners() {
        List<Car> cars = carRepository.getMaxDistanceCars();
        List<String> winnersName = cars.stream()
                .map(Car::getName)
                .toList();

        return new GetWinnersResponse(winnersName);
    }

    private List<Map<String, Integer>> getMoveData(int attemptCount, List<Car> cars) {
        List<Map<String, Integer>> roundMoveData = new ArrayList<>();
        while (attemptCount-- > 0) {
            Map<String, Integer> moveData = getCarMoveSnapshot(cars);
            roundMoveData.add(moveData);
        }

        return roundMoveData;
    }

    private Map<String, Integer> getCarMoveSnapshot(List<Car> cars) {
        Map<String, Integer> moveSnapshot = new HashMap<>();
        for (Car car : cars) {
            car.move();
            moveSnapshot.put(car.getName(), car.getDistance());
        }

        return moveSnapshot;
    }
}
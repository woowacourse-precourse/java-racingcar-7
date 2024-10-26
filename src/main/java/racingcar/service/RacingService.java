package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.RacingResponse;

import java.util.*;
import java.util.stream.Collectors;

public class RacingService {

    public RacingResponse startRace(String[] carName, int attemptCount) {
        List<Car> cars = getCars(carName);
        List<Map<String, Integer>> moveData = getMoveData(attemptCount, cars);
        List<String> winners = getWinners(cars);

        return new RacingResponse(moveData, winners);
    }

    private List<Car> getCars(String[] carName) {
        return Arrays.stream(carName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<Map<String, Integer>> getMoveData(int attemptCount, List<Car> cars) {
        List<Map<String, Integer>> moveData = new ArrayList<>();
        while(attemptCount-- > 0) {
            Map<String, Integer> moveSnapshot = getCarMoveSnapshot(cars);
            moveData.add(moveSnapshot);
        }

        return moveData;
    }

    private Map<String, Integer> getCarMoveSnapshot(List<Car> cars) {
        Map<String, Integer> move = new HashMap<>();
        for (Car car : cars) {
            car.move();
            move.put(car.getName(), car.getDistance());
        }

        return move;
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceManager {
    private static final int MOVE_THRESHOLD = 3;
    private final OutputProcesser outputProcesser;

    public RaceManager(OutputProcesser outputProcesser) {
        this.outputProcesser = outputProcesser;
    }

    public void startRace(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            List<Car> carsToMove = cars.stream()
                    .filter(car -> canMove())
                    .collect(Collectors.toList());

            carsToMove.forEach(Car::addDistance);
            outputProcesser.printRaceResult(cars);
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > MOVE_THRESHOLD;
    }

    public String getWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int getMaxDistance(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return maxDistance;
    }
}

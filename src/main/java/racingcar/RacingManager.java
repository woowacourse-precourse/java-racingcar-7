package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<Car> cars;
    private final int stageCount;
    private final List<StageResult> stageResults;

    public RacingManager(List<String> carNames, int stageCount) {
        this.stageCount = stageCount;
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.stageResults = new ArrayList<>(stageCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getStageCount() {
        return stageCount;
    }

    public List<StageResult> startRace() {
        for (int i = 0; i < stageCount; i++) {
            cars.forEach(car -> {
                int number = Randoms.pickNumberInRange(0, 9);
                car.attemptMove(number);
            });
            stageResults.add(new StageResult(cars));
        }
        return stageResults;
    }

    public void printResult() {
        for (StageResult result : stageResults) {
            result.print();
        }
        System.out.println();
        System.out.println("최종 우승자 : " + String.join(", ", winners()));
    }

    public List<String> winners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalAccessError::new);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}

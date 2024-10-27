package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<Car> cars;
    private final int stageCount;
    private final List<StageResult> results;

    public RacingManager(List<String> carNames, int stageCount) {
        this.stageCount = stageCount;
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.results = new ArrayList<>(stageCount);
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
            results.add(new StageResult(cars));
        }
        return results;
    }

    public void printResult() {
        for (StageResult result : results) {
            result.print();
        }
        System.out.println();
    }
}

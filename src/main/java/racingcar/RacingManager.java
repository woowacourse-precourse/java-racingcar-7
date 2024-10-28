package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingManager {

    private final List<Car> cars;
    private final int count;
    private final RacingResult racingResult;

    public RacingManager(List<String> carNames, int count) {
        this.count = count;
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.racingResult = new RacingResult(count);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    public RacingResult startRace() {
        for (int i = 0; i < count; i++) {
            moveCars();
            racingResult.takeSnapshot(cars);
        }
        return racingResult;
    }

    private void moveCars() {
        cars.forEach(car -> {
            int number = Randoms.pickNumberInRange(0, 9);
            car.tryMove(number);
        });
    }
}

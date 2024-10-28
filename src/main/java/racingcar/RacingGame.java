package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int trialCount;

    public RacingGame(String carNamesInput, int trialCount) {
        validateCarNames(carNamesInput);
        for (String name : carNamesInput.split(",")) {
            cars.add(new Car(name));
        }
        this.trialCount = trialCount;
    }

    private void validateCarNames(String carNamesInput) {
        for (String name : carNamesInput.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void start() {
        for (int i = 0; i < trialCount; i++) {
            race();
        }
    }

    private void race() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

}
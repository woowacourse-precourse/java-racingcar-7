package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> result;

    public Race() {
        this.result = new ArrayList<>();
    }

    public List<Car> getResult() {
        return Collections.unmodifiableList(result);
    }

    public void register(String[] carNames) {
        for(String carName : carNames) {
            result.add(new Car(carName));
        }
    }

    public void moveCarsIfQualified() {
        for (Car car : result) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= THRESHOLD) {
               car.moveForward();
            }
        }
    }
}

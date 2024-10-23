package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {

    private int attempts;

    public List<String> splitCarNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void parseAttempts(String input) {
        try {
            attempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (attempts < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void randomlyAccelerate(Car car) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        car.forwardOrStop(randomValue);
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {

    private int attempts;
    private final List<String> carList = new ArrayList<>();

    public int getAttempts() {
        return attempts;
    }

    public List<String> getCarList() {
        return carList;
    }

    public void parseCarList(String carNames) {
        carList.addAll(Arrays.asList(carNames.split(",")));
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

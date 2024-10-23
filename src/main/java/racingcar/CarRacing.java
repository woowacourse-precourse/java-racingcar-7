package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private int attempts;
    private final List<Car> carList = new ArrayList<>();

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void parseCarList(String carNames) {
        for (String CarName : carNames.split(",")) {
            carList.add(new Car(CarName));
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

    public void race() {
        int n = carList.size();
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < n; j++) {
                Car car = carList.get(j);
                randomlyAccelerate(car);
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }
}

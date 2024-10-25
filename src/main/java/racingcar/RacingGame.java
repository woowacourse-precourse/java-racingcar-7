package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;


    public void registerCars(String input) {
        StringTokenizer strtok = new StringTokenizer(input, ",");

        while (strtok.hasMoreTokens()) {
            String carName = strtok.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }
    }

    public void setTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
        this.tryCount = tryCount;
    }

}

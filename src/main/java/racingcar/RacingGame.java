package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

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

}

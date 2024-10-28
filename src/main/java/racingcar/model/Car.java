package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Car {
    private final String name;
    private Integer distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String formatName() {
        return this.name;
    }

    public String formatDistance() {
        return "-".repeat(this.distance);
    }

    public void randForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }

    public boolean isFarther(Car car) {
        return this.distance > car.distance;
    }

    public static ArrayList<String> parseWinnerNames(ArrayList<Car> cars) {
        Car farthestCar = cars.getFirst();

        for (Car car : cars) {
            if (car.isFarther(farthestCar)) {
                farthestCar = car;
            }
        }

        Integer farthestDistance = farthestCar.distance;
        ArrayList<String> names = new ArrayList<>();

        for (Car car : cars) {
            if (car.distance == farthestDistance) {
                names.add(car.name);
            }
        }

        return names;
    }
}

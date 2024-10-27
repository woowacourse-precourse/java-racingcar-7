package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = List.of("pobi", "woni");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}

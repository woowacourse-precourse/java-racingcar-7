package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandNumGenerator;

public class Cars {
    private final List<Car> cars;
    private final RandNumGenerator randNumGenerator = new RandNumGenerator();

    public Cars(String carsNames) {
        String[] splitNames = carsNames.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .toList();
    }

    public void roundProcess() {
        for (Car car : cars) {
            car.updatePositionComparedToRandNum(randNumGenerator);
        }
    }
}

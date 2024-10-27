package racingcar.domain;

import racingcar.view.InputForm;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int roundCount;

    public Race(List<Car> cars, int roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public static Race create(InputForm inputForm) {
        List<Car> cars = new ArrayList<>();
        for (String name : inputForm.getNames()) {
            cars.add(new Car(name));
        }

        return new Race(cars, inputForm.getRoundCount());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarCount() {
        return cars.size();
    }

    public int getRoundCount() {
        return roundCount;
    }

}

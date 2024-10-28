package racingcar;

import java.util.ArrayList;

public class Race {
    private Input input = new Input();
    private ArrayList<Car> cars = new ArrayList<>();

    public void setRace() {
        input.setCarNames();
        input.setRounds();

        for (String name : input.getCarNames()) {
            cars.add(new Car(name));
        }
    }
}
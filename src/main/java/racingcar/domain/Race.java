package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int rounds = 0;

    public void setCars(String input) {
        String[] carName = splitInput(input);

        for (String name : carName) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 작성해주세요.");
            }
            cars.add(new Car(name.trim()));
        }
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }

    private String[] splitInput(String input) {
        return input.split(",");
    }
}

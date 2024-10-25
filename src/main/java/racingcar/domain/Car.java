package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.util.RandomUtil;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    protected Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void playRound() {
        move(RandomUtil.pickCarNumber());
    }

    public void move(int carNumber) {
        if (carNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarDto getDto() {
        return new CarDto(name, position);
    }
}

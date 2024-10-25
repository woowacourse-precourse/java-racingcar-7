package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarDto;

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

    public void move(int random) {
        if (random >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void playRound() {
        move(Randoms.pickNumberInRange(0, 9));
    }

    public CarDto getDto() {
        return new CarDto(name, position);
    }
}

package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.util.RandomUtil;

public class Car {
    
    private static final int INIT_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final String name;
    private int position = INIT_POSITION;

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
        if (carNumber >= MOVE_STANDARD) {
            position += DEFAULT_MOVE_DISTANCE;
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

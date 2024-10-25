package racingcar.domain;

import racingcar.constant.ExceptionMessage;
import racingcar.dto.CarDto;
import racingcar.util.RandomUtil;

public class Car {
    
    private static final int INIT_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final String name;
    private int position = INIT_POSITION;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    protected Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_LENGTH_MUST_BE_LESS.getMessage(5));
        }
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

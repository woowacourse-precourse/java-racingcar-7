package racingcar.car;

import racingcar.message.ExceptionMessage;
import racingcar.validator.CarNameValidator;

import java.util.Objects;

import static racingcar.message.ExceptionMessage.*;

public class Car {
    private final String name;
    private int position;

    private final static String STICK = "-";

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber){
        if(randomNumber >= 4) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 테스트시 tearDown을 위한 메서드
    public void clearPosition(){
        this.position = 0;
    }

    @Override
    public String toString() {
        if(position < 0) throw new IllegalArgumentException(POSITION_UNDER_ZERO.getMessage());

        String progress = STICK.repeat(position);
        return name + " : " + progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

package racingcar.exception.message;


import static racingcar.domain.car.Name.MAX_LENGTH;
import static racingcar.domain.car.Name.MIN_LENGTH;

public class CarNameExceptionMessage {
    private CarNameExceptionMessage() {
    }

    public static final String MAX_LENGTH_EXCEEDED =
            String.format("자동차 이름은 최대 %d자까지 가능합니다.", MAX_LENGTH);

    public static final String MIN_LENGTH_REQUIRED =
            String.format("자동차 이름은 최소 %d자부터 가능합니다.", MIN_LENGTH);

}

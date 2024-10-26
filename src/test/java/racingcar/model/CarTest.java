package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름으로_자동차를_생성() {
        Car car = new Car("pobi");

        assertThat(car.getName())
                .isEqualTo("pobi");
    }

    @Test
    void 자동차_이름이_5자보다_많으면_예외() {
        assertThatThrownBy(() ->
                new Car("overlength"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_LENGTH_EXCEPTION.message());
    }

    @Test
    void 무작위_값이_4_이상이면_자동차_전진() {
        TestCar car = new TestCar("pobi");
        car.setRandomNumber(6);
        car.move();

        assertThat(car.getPosition())
                .isEqualTo(1);
    }

    @Test
    void 무작위_값이_4_미만이면_자동차_정지() {
        TestCar car = new TestCar("pobi");
        car.setRandomNumber(3);
        car.move();

        assertThat(car.getPosition())
                .isEqualTo(0);
    }
}

class TestCar extends Car {
    private int randomNumber = 0;

    public TestCar(String name) {
        super(name);
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    protected int getRandomNumber() {
        return randomNumber;
    }
}

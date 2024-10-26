package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 무작위_숫자가_4_이상() {
        Car car = new TestCar("pobi", true);

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_숫자가_4_미만() {
        Car car = new TestCar("pobi", false);

        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

class TestCar extends Car {
    private final boolean movable;
    public TestCar(String name, boolean movable) {
        super(name);
        this.movable = movable; // 움직일지 말지를 임의로 결정
    }

    @Override
    protected boolean isMovable() {
        return movable;
    }
}
package racingcar.model.Car.move;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ForwardTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Forward forward;

    @BeforeEach
    void setUp() {
        forward = new Forward();
    }


    @Test
    void 랜덤값이_0에서_9까지만_나오는지_확인() {
        for (int i = 0; i < 1000; i++) {
            int randomValue = forward.moveByRandom();
            assertThat(randomValue).isBetween(0, 9);
        }
    }

    @Test
    void move_함수가_4이상일_때_차가_전진하는지_확인() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));

        // moveByRandom이 4일 때 전진하도록 설정
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    forward.move(cars);
                    assertThat(cars.get(0).getMoveCount()).isEqualTo(1);
                    assertThat(cars.get(1).getMoveCount()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void move_함수가_3일_때_차가_전진하지_않는지_확인() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));

        // moveByRandom이 3일 때 전진하지 않도록 설정
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    forward.move(cars);
                    assertThat(cars.get(0).getMoveCount()).isEqualTo(0);
                    assertThat(cars.get(1).getMoveCount()).isEqualTo(0);
                },
                STOP
        );
    }
}

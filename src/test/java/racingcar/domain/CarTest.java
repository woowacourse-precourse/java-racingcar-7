package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.factory.CarFactory;

public class CarTest {
    @Test
    void 객체_생성_시_이름과_이동거리_저장() {
        String testName = "pobi";

        Car car = CarFactory.createCar(testName);

        assertThat(car.getName()).isEqualTo(testName);
        assertThat(car.getMoveDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤넘버_4이상이면_전진(int moveForwardNumber) {
        Car car = CarFactory.createCar("pobi");

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getMoveDistance()).isEqualTo(1);
                },
                moveForwardNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤넘버_4미만이면_멈춤(int moveStopNumber) {
        Car car = CarFactory.createCar("pobi");

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getMoveDistance()).isEqualTo(0);
                },
                moveStopNumber
        );
    }

}

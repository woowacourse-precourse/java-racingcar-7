package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private static Car car;
    private String testName = "pobi";

    @BeforeEach
    void createCar() {
        car = CarFactory.createCar(testName);
    }

    @Test
    void 객체_생성_시_이름과_이동거리_저장() {
        assertThat(car.getName()).isEqualTo(testName);
        assertThat(car.getMoveDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤넘버_4이상이면_전진(int moveForwardNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getMoveDistance()).isEqualTo(1);
                },
                moveForwardNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_반복(int moveForwardNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    car.move();
                    car.move();
                    assertThat(car.getMoveDistance()).isEqualTo(3);
                },
                moveForwardNumber, moveForwardNumber, moveForwardNumber
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤넘버_4미만이면_멈춤(int moveStopNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getMoveDistance()).isEqualTo(0);
                },
                moveStopNumber
        );
    }

    @Test
    void 랜덤넘버_모듈_테스트() {
        assertThat(Randoms.pickNumberInRange(0, 9)).isBetween(0, 9);
        assertThat(Randoms.pickNumberInRange(0, 9)).isBetween(0, 9);
        assertThat(Randoms.pickNumberInRange(0, 9)).isBetween(0, 9);
        assertThat(Randoms.pickNumberInRange(0, 9)).isBetween(0, 9);
        assertThat(Randoms.pickNumberInRange(0, 9)).isBetween(0, 9);
    }

}

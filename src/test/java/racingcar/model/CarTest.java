package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.constant.ExceptionMessage;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int INITIAL_POSITION = 0;

    private RacePolicy racePolicy;

    @BeforeEach
    void setUp() {
        this.racePolicy = new RacePolicy();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void testCreateCar() {
        String name = "test";
        Car car = new Car(racePolicy, name);
        assertAll(
                () -> assertThat(car.getName()).isEqualTo(name),
                () -> assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름에 null 또는 빈 문자열을 입력시 예외가 발생한다.")
    void testEmptyName(String name) {
        assertThatThrownBy(() -> new Car(racePolicy, name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_EMPTY_STRING.getMessage());
    }

    @Test
    @DisplayName("6자 넘는 이름을 입력시 예외가 발생한다.")
    void testInvalidLengthName() {
        String name = "length6test";
        assertThatThrownBy(() -> new Car(racePolicy, name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_LENGTH_LIMITATION.getMessage());
    }

    @Test
    @DisplayName("랜덤 정수가 4이상이면, 자동차가 전진한다.")
    void testMoveForward() {
        Car car = new Car(racePolicy, "test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.tryMoveForward();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("랜덤 정수가 4미만이면, 자동차가 전진한다.")
    void testDoNotMoveForward() {
        Car car = new Car(racePolicy, "test");
        assertRandomNumberInRangeTest(
                () -> {
                    car.tryMoveForward();
                    assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION);
                },
                STOP
        );
    }
}

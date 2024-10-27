package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final String CAR_NAME = "pobi";
    private static final String EXECUTE_RESULT_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";
    private static final int MOVE_LENGTH = 3;
    private static final int MINIMUM_MOVE_LENGTH = 3;

    private Car car;

    @BeforeEach
    void setUp() {
        //given
        car = Car.createCar(CAR_NAME);
    }

    @Test
    @DisplayName("자동차 생성 시 초기 위치는 0이어야 한다.")
    void positionShouldBeZeroWhenCreateCar() {
        //when
        String position = car.displayPosition();

        //then
        assertThat(position).isEqualTo(CAR_NAME + EXECUTE_RESULT_DELIMITER + NEW_LINE);
    }

    @RepeatedTest(10)
    @DisplayName("자동차가 여러 번 이동하면 그에 따른 위치를 출력해야 한다.")
    void printPositionWhenCarHasMultipleMoves() {
        //given
        for (int i = 0; i < MOVE_LENGTH; i++) {
            car.move();
        }

        //when
        String actualPosition = car.displayPosition();

        //then
        if (!actualPosition.equals(CAR_NAME + EXECUTE_RESULT_DELIMITER)) {
            assertThat(actualPosition.length())
                    .isGreaterThan(CAR_NAME.length() + MINIMUM_MOVE_LENGTH);
        }
    }
}
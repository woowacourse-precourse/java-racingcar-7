package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.CarImpl;

public class CarImplTests extends NsTest {

    private CarImpl car;

    @BeforeEach
    public void initCar() {
        car = new CarImpl("gana");
    }

    @ParameterizedTest
    @DisplayName("4 이상의 값으로 전진 가능")
    @ValueSource(ints = {4, 5, 9})
    public void drive(int randomNum) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.drive();
                },
                randomNum
        );

        assertThat(car.getPosition())
                .isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("4 미만의 값으로 전진 불가")
    @ValueSource(ints = {0, 1, 3})
    public void driveButNeverGo(int randomNum) {
        assertRandomNumberInRangeTest(
                () -> {
                    car.drive();
                },
                randomNum
        );

        assertThat(car.getPosition())
                .isEqualTo(0);
    }

    @Override
    protected void runMain() {
        // not use
    }
}

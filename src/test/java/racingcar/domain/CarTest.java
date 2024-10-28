package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.Message.ErrorMessage.NAME_MAX_LENGTH_ERROR;
import static racingcar.util.Message.ErrorMessage.NAME_MIN_LENGTH_ERROR;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class CarTest extends NsTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("minso");
    }


    @ParameterizedTest
    @DisplayName("자동차 이름 글자수가 6글자 이상일 경우 예외처리 검증")
    @ValueSource(strings = {"minseo", "sojung", "elephant"})
    void carNameMaxLengthExceptionTest(final String inputString) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Car(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_MAX_LENGTH_ERROR);
    }

    @Test
    @DisplayName("자동차 이름 글자수가 1글자 미만일 경우 = 빈문자열일 경우 예외처리 검증")
    void carNameLeastLengthExceptionTest() {
        // given
        final String inputString = "";
        // when
        // then
        assertThatThrownBy(() -> new Car(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_MIN_LENGTH_ERROR);
    }

    @Test
    @DisplayName("자동차가 1칸씩 잘 움직이는지 검증")
    void moveForwardIncreasesMoveCountTest() {
        // given
        // when
        car.moveFoward();
        // then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동한 거리를 나태내는 문자열을 잘 반환하는지 검증")
    void GetCurrentDistanceTest() {
        // given
        // when
        car.moveFoward();
        car.moveFoward();
        car.moveFoward();
        // then
        assertThat(car.getCurrentDistance()).isEqualTo("---");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

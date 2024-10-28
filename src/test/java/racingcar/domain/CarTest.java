package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exception.ErrorMessage;

public class CarTest {
    private static final String CORRECT_CAR_NAME = "geun";
    private static final int CAR_MOVE_COUNT_START = 0;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차를_성공적으로_생성한다.")
    void 자동차를_성공적으로_생성한다() {
        // given
        String name = CORRECT_CAR_NAME;

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT_START);
    }

    @Test
    @DisplayName("자동차_이름이_빈_문자열이여서_예외를_반환한다.")
    void 자동차_이름이_빈_문자열이여서_예외를_반환한다() {
        // given
        String name = "";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name))
                .withMessage(ErrorMessage.BLANK_CAR_NAME_ERROR.getMessage());
    }

    @Test
    @DisplayName("자동차_이름의_길이가_초과해서_예외를_반환한다.")
    void 자동차_이름의_길이가_초과해서_예외를_반환한다() {
        // given
        String name = "geunnn";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name))
                .withMessage(ErrorMessage.CAR_NAME_TOO_LONG_ERROR.getMessage());
    }

    @Test
    @DisplayName("무작위_숫자가_전진_조건을_충족하여_자동차가_이동한다.")
    void 무작위_숫자가_전진_조건을_충족하여_자동차가_이동한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Car car = new Car(CORRECT_CAR_NAME);

                    // when
                    car.tryMove();

                    // then
                    assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT_START + 1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("무작위_숫자가_전진_조건을_충족하지_않아_자동차가_이동하지_않는다.")
    void 무작위_숫자가_전진_조건을_충족하지_않아_자동차가_이동하지_않는다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Car car = new Car(CORRECT_CAR_NAME);

                    // when
                    car.tryMove();

                    // then
                    assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT_START);
                },
                STOP
        );
    }
}

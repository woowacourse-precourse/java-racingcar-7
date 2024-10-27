package racingcar.util.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BasicRacingCarGameValidatorTest {

    private final BasicRacingCarGameValidator basicRacingCarGameValidator;

    public BasicRacingCarGameValidatorTest() {
        this.basicRacingCarGameValidator = new BasicRacingCarGameValidator();
    }

    @Test
    public void 경주_자동차_이름_1자미만_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("");

            // when
            assertThatThrownBy(() -> basicRacingCarGameValidator.validateCarNames(names))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Test
    public void 경주_자동차_이름_5자초과_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("5자초과이름");

            // when
            assertThatThrownBy(() -> basicRacingCarGameValidator.validateCarNames(names))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_이동횟수_1회미만_테스트() {
        assertSimpleTest(() -> {
            // given
            int moveCount = 0;

            // when
            assertThatThrownBy(() -> basicRacingCarGameValidator.validateMoveCount(moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_0명_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = new ArrayList<>();

            // when
            assertThatThrownBy(() -> basicRacingCarGameValidator.validateCarNames(names))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_이름_중복_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("창의", "창의");

            // when
            assertThatThrownBy(() -> basicRacingCarGameValidator.validateCarNames(names))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_이름_1자이상_5자이하_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("창의", "민규", "상현");

            // when
            basicRacingCarGameValidator.validateCarNames(names);

            // then
            // 예외가 발생하지 않는다.

        });
    }

    @Test
    public void 경주_자동차_이동횟수_1회이상_테스트() {
        assertSimpleTest(() -> {
            // given
            int moveCount = 1;

            // when
            basicRacingCarGameValidator.validateMoveCount(moveCount);

            // then
            // 예외가 발생하지 않는다.

        });
    }


}

package racingcar.util.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BasicRacingCarValidatorTest {

    private final BasicRacingCarValidator basicRacingCarValidator;

    public BasicRacingCarValidatorTest() {
        this.basicRacingCarValidator = new BasicRacingCarValidator();
    }

    @Test
    public void 경주_자동차_이름_1자미만_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("");
            int moveCount = 1;

            // when
            assertThatThrownBy(() -> basicRacingCarValidator.validateCarNamesAndMoveCount(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Test
    public void 경주_자동차_이름_5자초과_테스트() {
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("5자초과이름");
            int moveCount = 1;

            // when
            assertThatThrownBy(() -> basicRacingCarValidator.validateCarNamesAndMoveCount(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_이동횟수_1회미만_테스트(){
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("창의");
            int moveCount = 0;

            // when
            assertThatThrownBy(() -> basicRacingCarValidator.validateCarNamesAndMoveCount(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_0명_테스트(){
        assertSimpleTest(() -> {
            // given
            List<String> names = new ArrayList<>();
            int moveCount = 1;

            // when
            assertThatThrownBy(() -> basicRacingCarValidator.validateCarNamesAndMoveCount(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 경주_자동차_이름_1자이상_5자이하_이동횟수_1회이상_테스트(){
        assertSimpleTest(() -> {
            // given
            List<String> names = List.of("창의", "민규", "상현");
            int moveCount = 5;

            // when
            basicRacingCarValidator.validateCarNamesAndMoveCount(names, moveCount);

            // then
            // 예외가 발생하지 않는다.

        });
    }


}

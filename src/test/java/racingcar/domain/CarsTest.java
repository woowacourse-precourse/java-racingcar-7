package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exception.ErrorMessage;

public class CarsTest {
    private static final String CORRECT_INPUT_NAME = "pobi,woni";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차_일급_컬렉션을_성공적으로_생성한다.")
    void 자동차_일급_컬렉션을_성공적으로_생성한다() {
        // given & when
        Cars cars = new Cars(CORRECT_INPUT_NAME);

        // then
        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("모든_자동차를_전진한다.")
    void 모든_자동차를_전진한다() {
        String expect = "pobi : -\nwoni : -\n";

        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Cars cars = new Cars(CORRECT_INPUT_NAME);

                    // when
                    cars.playSingleRound();

                    // then
                    assertThat(cars.toString()).isEqualTo(expect);
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("모든_자동차가_전진하지_못했다.")
    void 모든_자동차가_전진하지_못했다() {
        String expect = "pobi : \nwoni : \n";

        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Cars cars = new Cars(CORRECT_INPUT_NAME);

                    // when
                    cars.playSingleRound();

                    // then
                    assertThat(cars.toString()).isEqualTo(expect);
                },
                STOP, STOP
        );
    }

    @Test
    @DisplayName("가장_많이_전진한_자동차를_찾는다.")
    void 가장_많이_전진한_자동차를_찾는다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    Cars cars = new Cars(CORRECT_INPUT_NAME);

                    // when
                    for (int round = 1; round <= 2; round++) {
                        cars.playSingleRound();
                    }

                    // then
                    List<String> winnerNames = cars.getWinnerNames();
                    assertThat(winnerNames.size()).isEqualTo(1);
                    assertThat(winnerNames.getFirst()).isEqualTo("pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("중복된_자동차_이름을_입력하여_예외를_반환한다.")
    void 중복된_자동차_이름이_있어서_예외를_반환한다() {
        // given
        String duplicateName = "pobi,pobi";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(duplicateName))
                .withMessage(ErrorMessage.DUPLICATE_CAR_NAME_ERROR.getMessage());
    }
}

package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.global.message.ErrorMessage;
import racingcar.global.utils.ParseStringUtils;
import racingcar.global.utils.RaceRandomUtils;

class UtilsTest {

    @Test
    void 정상적인_자동차_이름_분리() {
        String carNamesInput = "pobi,woni,jun";
        List<String> carNames = ParseStringUtils.splitCarNames(carNamesInput);

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 연속된_쉼표_예외() {
        String carNamesInput = "pobi,,jun";

        assertThatThrownBy(() -> ParseStringUtils.splitCarNames(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONSECUTIVE_COMMAS.getMessage());
    }

    @Test
    void 빈_이름_입력_예외() {
        String carNamesInput = "pobi, ,jun";

        assertThatThrownBy(() -> ParseStringUtils.splitCarNames(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    void 이름_양쪽_공백_제거_테스트() {
        String carNamesInput = "pobi , woni ,  jun ";
        List<String> carNames = ParseStringUtils.splitCarNames(carNamesInput);

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @RepeatedTest(100)
    void 랜덤_숫자_생성_테스트() {
        int randomNumber = RaceRandomUtils.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}


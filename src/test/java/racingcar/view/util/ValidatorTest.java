package racingcar.view.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.view.util.ErrorMessage.라운드_숫자_입력_에러;
import static racingcar.view.util.ErrorMessage.라운드_양수_입력_에러;
import static racingcar.view.util.ErrorMessage.차_이름_크기_에러;
import static racingcar.view.util.ErrorMessage.차_입력_에러;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 차_입력_최소2개_확인() {
        List<String> carnames = List.of("pobi");
        assertThatThrownBy(() -> {
            validator.validateMinCarCount(carnames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(차_입력_에러.getMessage());
    }

    @Test
    void 차_이름_크기_최대5_확인() {
        List<String> carnames = List.of("pobi", "raccoon");
        assertThatThrownBy(() -> {
            validator.validateCarNameLength(carnames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(차_이름_크기_에러.getMessage());
    }

    @Test
    void 라운드_입력_숫자만_확인() {
        String totalRound = "five";
        assertThatThrownBy(() -> {
            validator.tryParserToInt(totalRound);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(라운드_숫자_입력_에러.getMessage());
    }

    @Test
    void 라운드_입력_음수_확인() {
        String totalRound = "-5";
        assertThatThrownBy(() -> {
            Integer number = validator.tryParserToInt(totalRound);
            validator.validatePositiveNumber(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(라운드_양수_입력_에러.getMessage());
    }

    @Test
    void 라운드_입력_자연수_확인() {
        String totalRound = "5.6";
        assertThatThrownBy(() -> {
            validator.tryParserToInt(totalRound);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(라운드_숫자_입력_에러.getMessage());
    }
}
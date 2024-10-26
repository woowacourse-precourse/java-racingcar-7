package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.config.exception.input.count.LessCountException;
import racingcar.config.exception.input.count.MoreCountException;
import racingcar.config.exception.input.count.TypeMissCountException;
import racingcar.helper.validation.InputCountValid;

public class InputCountTest {

    @Test
    void 사용자는_숫자를_입력해야_한다() {
        String count = "asfd";

        assertThrows(TypeMissCountException.class, () -> InputCountValid.validTypeMissCount(count));
    }

    @Test
    void 사용자는_1보다_작은_숫자를_입력할_수_없다() {
        int count = 0;

        assertThrows(LessCountException.class, () -> InputCountValid.validLessCount(count));
    }

    @Test
    void 사용자는_최댓값보다_큰_숫자를_입력할_수_없다() {
        int count = Integer.MAX_VALUE;

        assertThrows(MoreCountException.class, () -> InputCountValid.validMoreCount(count));
    }

}

package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.ValidationUtil.*;

class ValidationUtilTest {
    @Test
    public void 이동_횟수는_정수여야_한다_정수가_아닌_경우() {
        String moveCount = "hi";
        assertThat(isInteger(moveCount)).isEqualTo(false);
    }

    @Test
    public void 이동_횟수는_빈_값이_아니여야한다_빈_값인_경우() {
        String moveCount = "";
        assertThat(isEmpty(moveCount)).isEqualTo(true);
    }

    @Test
    public void 이동_횟수는_1_이상이어야_한다_음수인_경우() {
        String moveCount = "-1";
        assertThat(isPositive(moveCount)).isEqualTo(false);
    }

    @Test
    public void 자동차_이름은_중복될_수_없다_중복인_경우() {
        List<String> carNames = Arrays.asList("a", "b", "a");
        assertThat(isDuplicate(carNames)).isEqualTo(true);
    }
}
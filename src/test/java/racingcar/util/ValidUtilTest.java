package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.ValidUtil.isNumeric;

class ValidUtilTest {
    @Test
    public void 이동_횟수는_숫자여야_한다_숫자가_아닌_경우(){
        String moveCount = "hi";
        assertThat(isNumeric(moveCount)).isEqualTo(false);
    }

}
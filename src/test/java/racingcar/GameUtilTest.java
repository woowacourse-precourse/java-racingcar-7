package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameUtilTest {

    @Test
    void 랜덤함수를_통해_숫자가_반환되는지_확인합니다() {
        // when
        Integer result = GameUtil.randomNumber();

        // then
        assertThat(result).isInstanceOf(Integer.class);
    }

    @Test
    void 숫자_4이상은_전진합니다() {
        // when
        Boolean result = GameUtil.isForward(4);

        // then
        assertTrue(result);
    }

    @Test
    void 숫자_4미만은_전진하지_않습니다() {
        // when
        Boolean result = GameUtil.isForward(3);

        // then
        assertFalse(result);
    }
}
package racingcar.race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.Racer;

public class RacerTest {
    @Test
    void 레이서_예외_테스트(){
        assertThatThrownBy(()->new Racer("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

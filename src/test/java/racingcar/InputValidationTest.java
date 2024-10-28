package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class InputValidationTest {

    @Test
    void 정상적인_이름_목록_입력처리_테스트() {
        Application.getCarNames("pobi,woni,jun");

        assertThat(Application.cars).containsExactly("pobi", "woni", "jun");
        assertThat(Application.carScores).containsOnlyKeys("pobi", "woni", "jun");
        assertThat(Application.carScores.values()).containsOnly(0);
    }

    @Test
    void 정상적인_이동_횟수_입력처리_테스트() {
        Application.getRepeatNum("5");

        assertThat(Application.repeat).isEqualTo(5);
    }


}

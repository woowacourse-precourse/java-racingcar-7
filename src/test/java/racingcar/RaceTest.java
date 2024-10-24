package racingcar;

import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    void 자동차경주_총라운드_최소_1회() {
        Assertions.assertThatThrownBy(() -> new Race(0, new Cars("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1회 이상 진행되어야 합니다.");

        Assertions.assertThatThrownBy(() -> new Race(-1, new Cars("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1회 이상 진행되어야 합니다.");
    }

//    @Test
//    void 레이스_결과() {
//        Assertions.assertThat(new Race(2, new Cars("pobi,woni")).renderScoreBoard())
//                .isEqualTo(true);
//    }

//    @Test
//    void 우승자_발표() {
//        Assertions.assertThat(new Race(5).getWinner())
//                .contains("pobi");
//    }
}

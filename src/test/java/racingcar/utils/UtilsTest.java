package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.global.utils.ParseStringUtils;

class UtilsTest {

    @Test
    void 정상적인_자동차_이름_분리() {
        String carNamesInput = "pobi,woni,jun";
        List<String> carNames = ParseStringUtils.splitCarNames(carNamesInput);

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }


    @Test
    void 이름_양쪽_공백_제거_테스트() {
        String carNamesInput = "pobi , woni ,  jun ";
        List<String> carNames = ParseStringUtils.splitCarNames(carNamesInput);

        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }
}


package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {

    @Test
    void 자동차이름_유효성검사() {
        GameService gameService = new GameService();
        assertThatThrownBy(() -> gameService.initCars("이름길이가초과된자동차이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다.");
    }

    @Test
    void 우승자결정_테스트() {
        GameService gameService = new GameService();
        gameService.initCars("pobi,woni,jun");
        // 특정 테스트 환경에서는 move()에 임의의 값을 설정하여 우승자를 테스트합니다.
    }
}

package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingServiceTest extends NsTest {
    @Test
    @DisplayName("요구사항 5")
    void 전진하는_조건_테스트() {
        int randomInt = 4;
        boolean isForwardMovable = false;
        if (randomInt >= 4) {
            isForwardMovable = true;
        }
        assertThat(isForwardMovable).isEqualTo(false);
    }

    @Test
    @DisplayName("요구사항 5")
    void 랜덤_숫자_생성() {
        int randomInt = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        assertThat(randomInt).isBetween(0, 9);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

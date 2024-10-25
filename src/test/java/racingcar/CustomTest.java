package racingcar;


import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomTest extends NsTest {

    @Test
    void 게임_횟수_유효성_검사_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 양수이어야 합니다.")
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자 이상일 경우 IllegalArgumentException가 발생해야한다.")
    void should_ThrowException_when_Over5Length() {
        String input = "pobiwoni, pobi, woni";
        assertThrows(IllegalArgumentException.class, () -> {
            Application.makeCars(input);
        });
    }

    @Test
    @DisplayName("입력 포맷이 적절하지 않을 경우 IllegalArgumentException가 발생해야한다.")
    void should_ThrowException_when_InvalidInputFormat() {
        assertAll(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        Application.setStage("abc");
                    });
                },
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        Application.setStage("-5");
                    });
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

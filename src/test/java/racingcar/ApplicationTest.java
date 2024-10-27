package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void 자동차_이름_검증_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji,tooLongName", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 시도횟수_검증_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상만 가능합니다.")
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상만 가능합니다.")
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 가능합니다.")
        );
    }

    @Test
    void 최종_우승자_여러명인_경우_계산_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "2");
                assertThat(output()).contains("최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

        @Test
    void 차수별_실행결과_출력_기능() {
        String carNames = "pobi,woni,jun";
        String tryTime = "2"; // 시도 횟수를 2로 설정

        assertRandomNumberInRangeTest(
            () -> {
                run(carNames, tryTime);

                // Then: 각 차수의 출력 결과를 검증합니다.
                assertThat(output()).contains(
                    "pobi : -",    // 1회
                    "woni : ",     // 1회
                    "jun : ",      // 1회
                    "pobi : --",   // 2회
                    "woni : ",   // 2회
                    "jun : "      // 2회
                );
            },
            MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

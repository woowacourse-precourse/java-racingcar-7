package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("특수 문자나 숫자가 포함된 자동차 이름이어도 정상적으로 실행된다.")
    void 자동차_이름_특수문자_숫자_허용() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("car 1,car#2", "1");
                    assertThat(output()).contains("car 1 : -", "car#2 : ", "최종 우승자 : car 1");
                },
                MOVING_FORWARD, STOP
        );
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "0.1", "1.1", "1.0", "a"})
    @DisplayName("시도 횟수가 유효하지 않은 경우 예외를 발생시킨다.")
    void 시도_횟수_유효성_검사_예외(String attemptCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", attemptCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource({"12345,c,car!"})
    @DisplayName("자동차 이름이 5자일 때 정상적으로 실행된다.")
    void 자동차_이름_5자(String carNames) {
        assertSimpleTest(() -> {
            run(carNames, "1");
            assertThat(output()).contains("최종 우승자");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

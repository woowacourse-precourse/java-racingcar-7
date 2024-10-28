package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 자동차_입력_테스트() {
        // Given: 테스트할 입력값 설정
        String input = "pobi,woni,jun";
        String inputLongName = "pobia, woni fang, junsubae";

        // When: getCarNames() 메서드 호출
        List<String> carNames = Application.splitCarNames(input);

        // Then: 결과 검증
        List<String> expectedNames = Arrays.asList("pobi", "woni", "jun");
        assertThat(carNames).isEqualTo(expectedNames);

        //예외 검증
        assertThatThrownBy(() -> Application.splitCarNames(inputLongName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

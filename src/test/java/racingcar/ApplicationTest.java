package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.*;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void testGetCarNames() {
        assertSimpleTest(() -> {
            // run 메서드에 입력을 순차적으로 전달
            run("pobi,woni,jun");
            List<String> carNames = Application.getCarNames();
            assertThat(carNames).containsExactly("pobi", "woni", "jun");
        });
    }

    @Test
    void testGetTotalRaceCount() {
        assertSimpleTest(() -> {
            // 두 번째 입력만 필요하므로 시도 횟수를 제공
            run("5");
            int totalRaceCount = Application.getTotalRaceCount();
            assertThat(totalRaceCount).isEqualTo(5);
        });
    }

    @Test
    void testIsValidCarNames() {
        assertSimpleTest(() -> {
            // 유효한 이름이 없는 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(null))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidCarNames(Collections.emptyList()))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("", "", "")))
                    .isInstanceOf(IllegalArgumentException.class);

            // 중복된 이름이 있는 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("pobi", "pobi", "jun")))
                    .isInstanceOf(IllegalArgumentException.class);

            // 이름 길이가 잘못된 경우 예외 발생
            assertThatThrownBy(() -> Application.isValidCarNames(Arrays.asList("pobi", "longName", "jun")))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

//    @Test
//    void 기능_테스트() {
//        assertRandomNumberInRangeTest(
//                () -> {
//                    run("pobi,woni", "1");
//                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
//                },
//                MOVING_FORWARD, STOP
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
//        Application.main(new String[]{});
    }
}
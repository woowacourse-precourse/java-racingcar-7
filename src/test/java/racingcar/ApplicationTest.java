package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
    @DisplayName("findMaxIndices 테스트 - 최댓값이 하나인 경우")
    void testFindMaxIndicesSingleMax() {
        int[] arr = {1, 3, 2};
        int[] result = Application.findMaxIndices(arr);

        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    @DisplayName("findMaxIndices 테스트 - 최댓값이 여러 개인 경우")
    void testFindMaxIndicesMultipleMax() {
        int[] arr = {3, 3, 2, 3};
        int[] result = Application.findMaxIndices(arr);

        assertArrayEquals(new int[]{0, 1, 3}, result);
    }

    @Test
    @DisplayName("findMaxIndices 테스트 - 빈 배열인 경우")
    void testFindMaxIndicesEmptyArray() {
        int[] arr = {};
        int[] result = Application.findMaxIndices(arr);

        assertArrayEquals(new int[]{}, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

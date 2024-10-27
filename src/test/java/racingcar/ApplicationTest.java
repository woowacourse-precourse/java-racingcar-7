package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("CarName Length Check")
    void testNameOverLengthLimit() {
        assertThatThrownBy(() -> {
            run("pobi,woni,kdu3840"); // "kdu3840" 길이 초과
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자 이하로 설정해야 합니다.");
    }

    @Test
    @DisplayName("Empty Car Name")
    void carNameIsEmpty() {
        assertThatThrownBy(() -> {
            run("\n");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여하는 자동차가 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("Attempt Count Check")
    @ValueSource(strings = {"0", "-1"})
    void attemptCountIsZeroOrNegative(String attemptCount) {
        assertThatThrownBy(() -> {
            run("pobi,woni", attemptCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상으로 설정해야 합니다.");
    }

    @Test
    @DisplayName("Single Winners Case")
    void singleWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output())
                            .withFailMessage("Single Winners Case Error")
                            .contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("Multiple Winners Case")
    void multipleWinners() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output())
                            .withFailMessage("Multiple Winners Case Error")
                            .contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

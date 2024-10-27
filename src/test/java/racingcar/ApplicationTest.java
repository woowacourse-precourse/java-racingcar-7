package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            FORWARD, STOP
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
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void nameExceedsFiveCharactersThrowsException() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,overfive", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름은 5자 이하만 가능합니다.");
        });
    }

    @Test
    @DisplayName("이동 횟수에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    void nonNumericInputThrowsException() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("횟수는 숫자만 입력할 수 있습니다.");
        });
    }

    @Test
    @DisplayName("정상적인 입력에 대해 우승자가 제대로 계산되는지 테스트한다.")
    void normalInputTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    String cleanOutput = getCleanOutput();
                    assertThat(cleanOutput).contains("최종 우승자 : pobi");
                },
                FORWARD, STOP, FORWARD, STOP, FORWARD, STOP
        );
    }

    @Test
    @DisplayName("동일한 거리를 이동한 경우 공동 우승자가 선정되는지 테스트한다.")
    void multipleWinnersTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    String cleanOutput = getCleanOutput();
                    assertThat(cleanOutput).contains("최종 우승자 : pobi,woni");
                },
                FORWARD, FORWARD, FORWARD, FORWARD
        );
    }

    private String getCleanOutput() {
        return output().lines()
                .filter(line -> !line.contains("Mockito"))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

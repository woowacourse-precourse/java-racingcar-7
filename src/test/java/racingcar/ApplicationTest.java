package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final Separator separator = new Separator();

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
    @DisplayName("이름이 5자 보다 크면 예외 발생")
    void 이름_초과_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열을 분리한다")
    void 구분자_테스트() {
        String input = "pobi,woni,jun";

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = separator.separate(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("이름과 이름 사이에 공백이 있을 경우 제거된 상태로 반환")
    void 이름_공백_테스트() {
        String input = " pobi , woni,    jun";

        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = separator.separate(input);

        Assertions.assertEquals(expected, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

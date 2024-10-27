package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    public void 빈_자동차이름_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.")
        );
    }

    @Test
    public void 빈_시도횟수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 비어있을 수 없습니다.")
        );
    }

    @Test
    public void 음수_시도횟수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 0보다 작을 수 없습니다.")
        );
    }

    @Test
    public void 자동차_이름에_공백이_있는_경우_테스트() {
        String carNames = "  pobi ,  woni ,  jun  ";
        List<String> result = Application.splitCarNames(carNames);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void 자동차_이름에_쉼표가_있는_경우_테스트() {
        String carNames = ",pobi,woni,,, ";
        List<String> result = Application.splitCarNames(carNames);
        assertThat(result).containsExactly("", "pobi", "woni", "", "", "");
    }

    @Test
    public void 자동차_이름이_5자_초과인_경우_테스트() {
        List<String> carNamesList = List.of("pobiii", "", "jun");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCarNamesList(carNamesList);
        });
        assertEquals("자동차 이름은 5자 이하이어야 합니다.", exception.getMessage());
    }

    @Test
    public void 자동차_이름이_공백인_경우_테스트() {
        List<String> carNamesList = List.of("pobi", "", "jun");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Application.validateCarNamesList(carNamesList);
        });
        assertEquals("자동차 이름이 유효하지 않습니다.", exception.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

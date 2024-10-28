package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("E2E_기본_기능_테스트")
    void testDefaultFeature() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("chang,sung,hyun,tae,sun,jae", "10");
                    assertThat(output()).contains(
                            "chang : -",
                            "sung : ",
                            "hyun : ",
                            "tae : ",
                            "sun : ",
                            "jae : ",
                            "최종 우승자 : chang"
                    );
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
    @DisplayName("E2E_특수문자_포함_자동차이름_테스트")
    void testInvalidCarNameWithSpecialCharacters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi~", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("E2E_경주_횟수_음수_입력_테스트")
    void testNegativeRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("E2E_최대_경주_횟수_초과_테스트")
    void testExceedingMaxRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("E2E_경주_횟수_실수_입력_테스트")
    void testRealNumberRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "3.14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("E2E_경주_횟수_문자_입력_테스트")
    void testCharacterRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "string"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("E2E_중복_이름_입력_테스트")
    void testDuplicateNameInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

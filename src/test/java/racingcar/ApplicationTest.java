package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void testInvalidCarNameWithSpecialCharacters() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi~", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testNegativeRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testExceedingMaxRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testRealNumberRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "3.14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testCharacterRaceCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "string"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
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

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomApplicationTest extends NsTest {

    @Test
    void SIMULATE_JUN_WIN() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "3");

                assertThat(output()).contains("pobi : -", "woni : ", "jun : -");
                assertThat(output()).contains("pobi : --", "woni : ", "jun : --");
                assertThat(output()).contains("pobi : --", "woni : -", "jun : --", "최종 우승자 : jun");
            },
            5, 3, 6,
            4, 1, 7,
            2, 4, 4
        );
    }

    @Test
    void SIMULATE_TIE_WIN() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            5, 5
        );
    }

    @Test
    void SIMULATE_NO_CAR_MOVE() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi :", "woni :", "최종 우승자 : pobi, woni");
            },
            0, 0
        );
    }

    @Test
    void SIMULATE_SINGLE_PLAYER() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi", "3");
                assertThat(output()).contains("pobi : --", "최종 우승자 : pobi");
            },
            4, 4, 2
        );
    }

    @Test
    void SIMULATE_ONLY_COMMAS_EXCEPTION() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run(",,,", "3"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_NEGATIVE_TRIAL_NUMBER() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi", "-1"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_NON_NUMBER_TRIAL() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi", "a"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_SPECIAL_CHARACTER_CAR_NAME() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi, wo@ni", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_TWO_COMMAS_BETWEEN_NAMES() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi,,woni", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_TRIAL_NUMBER_ZERO() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi,woni", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Test
    void SIMULATE_CAR_NAME_OVER_FIVE() {
        assertSimpleTest(
            () -> {
                assertThatThrownBy(() -> run("pobi,wonnni", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

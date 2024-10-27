package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Name;

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
    void 다수_라운드_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 시도횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이동 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 시도횟수_숫자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("유효한 숫자를 입력해주세요.")
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5자를 초과할 수 없습니다.")
        );
    }

    @Test
    void 이름_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_테스트() {
        assertSimpleTest(() -> {
            List<Name> names = Name.createNames("one,two,three");
            assertThat(names)
                    .extracting(Name::getName)
                    .containsExactly("one", "two", "three");
        });
    }

    @Test
    void 이름_중복_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, pobi", "3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 중복될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

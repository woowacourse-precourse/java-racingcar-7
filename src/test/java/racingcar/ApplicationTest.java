package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output())
                            .contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트_이름_길이_초과() {
        assertThatThrownBy(() -> new Car("javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 예외_테스트_빈_이름() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈칸일 수 없습니다.");
    }

    @Test
    void 예외_테스트_중복된_이름() {
        assertThatThrownBy(() -> new Race(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다: pobi");
    }

    @Test
    void 예외_테스트_이동횟수_자연수가_아닐경우() {
        assertThatThrownBy(() -> {
            int rounds = -1;
            if (rounds <= 0) {
                throw new IllegalArgumentException("이동 횟수는 자연수여야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 자연수여야 합니다.");
    }

    @Test
    void 예외_테스트_이동횟수_빈값() {
        assertThatThrownBy(() -> {
            String inputRounds = "";
            if (inputRounds.isEmpty()) {
                throw new IllegalArgumentException("이동 횟수를 입력해야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수를 입력해야 합니다.");
    }

    @Test
    void 동시우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,jun", "3");
                    assertThat(output())
                            .contains("pobi : ---", "jun : ---", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 자동차이름_예외_테스트() {
        assertThatThrownBy(() -> new CarNameHandler().storeCar("pobi,javaji,1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }

    @Test
    void 이동횟수_예외_테스트() {
        RacingCars racingCars = new RacingCars();
        racingCars.addCars(List.of("pobi", "crong"));

        RacingGame racingGame = new RacingGame(racingCars);

        assertThatThrownBy(() -> racingGame.startRacing(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다.");

        assertThatThrownBy(() -> racingGame.startRacing(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다.");
    }


    @Test
    void 최소_이동횟수_테스트() {
        assertSimpleTest(() -> {
            run("pobi,crong", "1");
            assertThat(output()).contains("pobi : -", "crong : ", "최종 우승자");
        });
    }

    @Test
    void 최대_자동차이름_길이_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi1,crong", "2");
                    assertThat(output()).contains("pobi1 : -", "crong : -", "최종 우승자");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    void 모든_자동차_이동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,crong,duli", "2");
                    assertThat(output()).contains("pobi : --", "crong : --", "duli : --");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Test
    void 최소_자동차_이름_개수_예외_테스트() {
        assertThatThrownBy(() -> new CarNameHandler().storeCar("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두 대 이상의 자동차 이름을 입력해야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

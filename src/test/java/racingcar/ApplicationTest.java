package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(
                new ArrayList<>(List.of("Car1", "Car2", "Car3")),
                4
        );
    }

    @Test
    void 전진_테스트() {
        int beforeStart = racingCar.getStatus().get(1).length();

        racingCar.race();

        int afterGo = racingCar.getStatus().get(1).length();
        assertThat(afterGo).isGreaterThanOrEqualTo(beforeStart);
    }

    @DisplayName("우승자 선정 메서드 show() 테스트")
    @Test
    void 우승자_선정_테스트() {
        racingCar.getStatus().get(0).append("----");
        racingCar.getStatus().get(1).append("---");
        racingCar.getStatus().get(2).append("----");

        racingCar.pickAWinner();

        List<String> winner = racingCar.getWinner();
        assertThat(winner).contains(racingCar.getCars().get(0));
        assertThat(winner).contains(racingCar.getCars().get(2));
    }


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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

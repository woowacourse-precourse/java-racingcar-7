package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingGame racingGame;
    @BeforeEach
    public void setUp() {
        List<Car> carList = List.of(new Car[]{new Car("pobi"), new Car("jun")});
        racingGame = new RacingGame(carList, 1);
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
    void 자동차_전진_테스트() {
        List<Car> carList = racingGame.getCarList();
        carList.get(0).move(5);
        carList.get(1).move(3);
        assertThat(carList.get(0).getPosition() == 1).isTrue();
        assertThat(carList.get(1).getPosition() == 0).isTrue();
    }

    @Test
    void 우승자_선정_테스트() {
        List<Car> carList = racingGame.getCarList();
        carList.get(0).move(5);
        carList.get(1).move(3);
        List<String> winner = racingGame.findWinner();
        assertThat(winner.get(0).equals(carList.get(0).getName())).isTrue();
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

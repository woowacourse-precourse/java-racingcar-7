package racingcar.start;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.Car;
import racingcar.RacingGame;

class RacingGameStartTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int NUM_CAR = 3;
    static RacingGame racingGame;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 게임시작_1라운드_테스트() throws Exception {
        racingGame = new RacingGame();
        //given
        List<Car> cars = new ArrayList<>();
        //when
        for (int i = 0; i < NUM_CAR; i++) {
            cars.add(new Car("car" + i));
        }
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    racingGame.startRound(cars);
                    assertThat(cars.get(0).getForwardCount()).isEqualTo(1);
                    assertThat(cars.get(1).getForwardCount()).isEqualTo(0);
                    assertThat(cars.get(2).getForwardCount()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    public void 게임시작_3라운드_테스트() throws Exception {
        //given
        racingGame = new RacingGame();
        List<Car> cars = new ArrayList<>();
        //when
        for (int i = 0; i < NUM_CAR; i++) {
            cars.add(new Car("car" + i));
        }
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    racingGame.start(cars, 2);
                    assertThat(cars.get(0).getForwardCount()).isEqualTo(2);
                    assertThat(cars.get(1).getForwardCount()).isEqualTo(0);
                    assertThat(cars.get(2).getForwardCount()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    public void 게임시작_3라운드_출력테스트() throws Exception {
        //given
        List<Car> cars = new ArrayList<>();
        //when
        for (int i = 0; i < NUM_CAR; i++) {
            cars.add(new Car("car" + i));
        }
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    racingGame.start(cars, 2);
                    assertThat(output()).isEqualTo("car0 : --");
                    assertThat(output()).isEqualTo("car1 : ");
                    assertThat(output()).isEqualTo("car2 : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }
}
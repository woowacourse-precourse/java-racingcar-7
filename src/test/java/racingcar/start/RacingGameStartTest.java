package racingcar.start;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

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
        String[] names = new String[NUM_CAR];
        for (int i = 0; i < NUM_CAR; i++) {
            names[i] = ("car" + i);
        }
        racingGame.ready(names,2);
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = racingGame.startRound();
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
        String[] names = new String[NUM_CAR];
        for (int i = 0; i < NUM_CAR; i++) {
            names[i] = ("car" + i);
        }
        //when
        racingGame.ready(names,2);
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 2; i++) {
                        racingGame.startRound();
                    }
                    assertThat(racingGame.getCars().get(0).getForwardCount()).isEqualTo(2);
                    assertThat(racingGame.getCars().get(1).getForwardCount()).isEqualTo(0);
                    assertThat(racingGame.getCars().get(2).getForwardCount()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    public void 게임시작_3라운드_출력테스트() throws Exception {
        //given
        RacingGameView racingGameView = new RacingGameView();
        racingGame = new RacingGame();
        String[] names = new String[NUM_CAR];
        for (int i = 0; i < NUM_CAR; i++) {
            names[i] = ("car" + i);
        }
        //when
        racingGame.ready(names,2);
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    for (int i = 0; i < 2; i++) {
                        List<Car> cars = racingGame.startRound();
                        racingGameView.printCurForward(cars);
                    }
                    assertThat(output()).contains("car0 : -");
                    assertThat(output()).contains("car1 : ");
                    assertThat(output()).contains("car2 : -");
                    assertThat(output()).contains("car0 : --");
                    assertThat(output()).contains("car1 : ");
                    assertThat(output()).contains("car2 : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }
}
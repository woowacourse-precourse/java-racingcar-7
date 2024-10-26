package racingcar.end;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class RacingGameEndTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int NUM_CAR = 3;
    static RacingGame racingGame;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 게임종료_단독우승_출력테스트() throws Exception {
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
                        racingGame.startRound();
                    }
                    List<String> winners = racingGame.end();
                    racingGameView.printWinners(winners);
                    assertThat(output()).contains("최종 우승자 : car0");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    public void 게임종료_2명이상우승_출력테스트() throws Exception {
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
                        racingGame.startRound();
                    }
                    List<String> winners = racingGame.end();
                    racingGameView.printWinners(winners);
                    assertThat(output()).contains("최종 우승자 : car0, car2");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

}

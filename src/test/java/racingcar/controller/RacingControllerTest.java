package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class RacingControllerTest {
    @Test
    void 자동차_경주() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int moveCount = 5;

        TestRacingController testRacingController = new TestRacingController(carNames, moveCount);
        testRacingController.run();

        OutputView outputView = testRacingController.getOutputView();
        assertThat(outputView.generateProgress()) // 마지막 진행상황
                .isEqualTo("pobi : -----\nwoni : -----\njun : -----");

        assertThat(outputView.generateWinners())
                .isEqualTo("최종 우승자 : pobi, woni, jun");
    }
}
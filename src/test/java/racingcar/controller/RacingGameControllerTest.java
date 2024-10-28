package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveDistanceProvider;
import racingcar.service.RacingGameService;
import racingcar.service.RacingGameServiceImpl;
import racingcar.validation.CarNamesValidatorImpl;
import racingcar.validation.RaceCountValidatorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingGameControllerTest {

    private TestInputView testInputView;
    private TestOutputView testOutputView;
    private RacingGameController racingGameController;

    @BeforeEach
    void setUp() {
        testInputView = new TestInputView("pobi,woni,jun", "3");
        testOutputView = new TestOutputView();
        RacingGameService racingGameService = new RacingGameServiceImpl(new CarNamesValidatorImpl(),
                new FixedMoveDistanceProvider(5));
        racingGameController = new RacingGameController(racingGameService, testInputView, testOutputView,
                new RaceCountValidatorImpl());
    }

    @Test
    @DisplayName("경주가 정상적으로 수행되고 결과가 예상대로 나오는지 테스트")
    void 경주_결과_테스트() {
        // when
        racingGameController.run();

        // then
        List<String> raceResults = testOutputView.getRaceResults();
        assertThat(raceResults).containsExactly(
                "pobi : -----", "woni : -----", "jun : -----",
                "pobi : ----------", "woni : ----------", "jun : ----------",
                "pobi : ---------------", "woni : ---------------", "jun : ---------------"
        );
        assertThat(testOutputView.getWinners()).isEqualTo("pobi, woni, jun");
    }

    class FixedMoveDistanceProvider implements MoveDistanceProvider {

        private final Integer fixedDistance;

        FixedMoveDistanceProvider(Integer fixedDistance) {
            this.fixedDistance = fixedDistance;
        }

        @Override
        public Integer generateMoveDistance() {
            return fixedDistance;
        }
    }

    class TestInputView implements InputView {

        private final String carNames;
        private final String raceCount;

        TestInputView(String carNames, String raceCount) {
            this.carNames = carNames;
            this.raceCount = raceCount;
        }

        @Override
        public String getCarNamesFormView() {
            return carNames;
        }

        @Override
        public String getRaceCountFormView() {
            return raceCount;
        }
    }

    class TestOutputView implements OutputView {
        private final List<String> raceResults = new ArrayList<>();
        private String winners;

        @Override
        public void printCarRaceGameResults(String carName, String progress) {
            raceResults.add(carName + " : " + progress);
        }

        @Override
        public void printWinners(String winners) {
            this.winners = winners;
        }

        public List<String> getRaceResults() {
            return raceResults;
        }

        public String getWinners() {
            return winners;
        }
    }
}
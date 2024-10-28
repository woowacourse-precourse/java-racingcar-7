package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RaceControllerTest {
    private RaceController raceController;
    private DummyRaceService dummyRaceService;
    private DummyOutputView dummyOutputView;

    @BeforeEach
    void setUp() {
        dummyRaceService = new DummyRaceService();
        dummyOutputView = new DummyOutputView();
        raceController = RaceController.getInstance(dummyRaceService, dummyOutputView);
    }

    @Test
    @DisplayName("경주_인스턴스_생성_테스트")
    void testGetRaceRequest() {
        assertSimpleTest(() -> {
            CarDomains cars = CarDomains.create(Arrays.asList(
                    CarDomain.create("Car1", 0),
                    CarDomain.create("Car2", 0)
            ));
            Integer lastRound = 3;

            RaceDomain raceDomain = raceController.getRaceRequest(cars, lastRound);

            assertNotNull(raceDomain);
            assertEquals(cars, raceDomain.getCars());
            assertEquals(lastRound, raceDomain.getLastRound());
        });
    }

    @Test
    @DisplayName("경주_실행_요청_테스트")
    void testExecuteRaceRequest() {
        assertSimpleTest(() -> {
            CarDomains cars = CarDomains.create(Arrays.asList(
                    CarDomain.create("Car1", 0),
                    CarDomain.create("Car2", 0)
            ));
            Integer lastRound = 3;
            RaceDomain raceDomain = RaceDomain.create(cars, lastRound);

            raceController.executeRaceRequest(raceDomain);

            assertTrue(dummyOutputView.isRoundResultDisplayed());
            assertEquals(lastRound, dummyRaceService.getRunCount());
            assertEquals(lastRound, dummyOutputView.getRoundCount());
        });
    }

    @Test
    @DisplayName("우승자_요청_테스트")
    void testGetWinnerRequest() {
        assertSimpleTest(() -> {
            CarDomains cars = CarDomains.create(Arrays.asList(
                    CarDomain.create("Car1", 2),
                    CarDomain.create("Car2", 0)
            ));
            CarDomains winners = CarDomains.create(
                    List.of(CarDomain.create("Car1", 2))
            );
            Integer lastRound = 3;
            RaceDomain raceDomain = RaceDomain.create(cars, lastRound);
            dummyRaceService.setWinners(winners);

            raceController.getWinnerRequest(raceDomain);

            assertTrue(dummyOutputView.isWinnerDisplayed());
        });
    }

    private static class DummyRaceService implements RaceService {
        private int runCount = 0;
        private CarDomains winners;

        @Override
        public void runOneRound(RaceDomain race) {
            runCount++;
        }

        @Override
        public CarDomains getWinners(RaceDomain race) {
            return winners;
        }

        public int getRunCount() {
            return runCount;
        }

        public void setWinners(CarDomains winners) {
            this.winners = winners;
        }
    }

    private static class DummyOutputView implements OutputView {
        private boolean roundResultDisplayed = false;
        private int roundCount = 0;
        private boolean winnerDisplayed = false;

        @Override
        public void displayRoundResultString() {
            roundResultDisplayed = true;
        }

        @Override
        public void displayEachRoundStatus(CarDomains cars) {
            roundCount++;
        }

        @Override
        public void displayCarRaceWinner(CarDomains winners) {
            winnerDisplayed = true;
        }

        public boolean isRoundResultDisplayed() {
            return roundResultDisplayed;
        }

        public int getRoundCount() {
            return roundCount;
        }

        public boolean isWinnerDisplayed() {
            return winnerDisplayed;
        }
    }
}
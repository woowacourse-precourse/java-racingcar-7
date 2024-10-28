package racingcar.application.service.winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.application.service.car.RacingCarService;

import static org.junit.jupiter.api.Assertions.assertFalse;

class WinnerServiceTest {

    private WinnerService winnerService;
    private RacingCarService racingCarService;

    @BeforeEach
    public void before() {
        winnerService = new WinnerService();
        racingCarService = new RacingCarService();
    }

    @Test
    void 우승자_저장하기() {
        racingCarService.inputCarName("car1,car2");
        racingCarService.inputTryNumber("3");
        racingCarService.startGame();

        winnerService.saveWinners();

        assertFalse(winnerService.getWinners().isEmpty());
    }
}
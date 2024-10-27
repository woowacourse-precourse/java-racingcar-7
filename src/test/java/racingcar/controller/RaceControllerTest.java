package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.RaceSetupFacade;
import racingcar.domain.*;
import racingcar.dto.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.lang.reflect.Method;
import java.util.List;

class RaceControllerTest {

    private RaceController raceController;
    private RaceProgressManager raceProgressManager;
    private RandomNumberGenerator randomNumberGenerator;
    private WinnerDecider winnerDecider;
    private OutputView outputView;
    private int attempts;
    private RaceSetupFacade setupFacade;
    private List<RacingCar> cars;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        outputView = new OutputView();
        setupFacade = new RaceSetupFacade(inputView, outputView);

        cars = List.of(new RacingCar("벤츠"), new RacingCar("볼보"));
        raceProgressManager = new RaceProgressManager(cars);
        randomNumberGenerator = new RandomNumberGenerator();
        winnerDecider = new WinnerDecider();
        attempts = 10;

        raceController = new RaceController(
                cars,
                raceProgressManager,
                randomNumberGenerator,
                winnerDecider,
                outputView,
                attempts,
                setupFacade
        );
    }

    @Test
    @DisplayName("경주 시작 시 실행 결과와 각 라운드 진행 상황 출력")
    void 경주_시작_테스트() throws Exception {
        invokePrivateMethod("startRace");

        RaceResult finalResult = raceProgressManager.createRaceResult();
        assertThat(finalResult).isNotNull();
        assertThat(finalResult.raceProgress()).containsKeys("벤츠", "볼보");

        assertThat(finalResult.raceProgress().values()).allMatch(progress -> progress >= 0);
    }

    @Test
    @DisplayName("라운드 진행 상황 출력 테스트")
    void 라운드_진행_상황_출력_테스트() throws Exception {
        invokePrivateMethod("runAllRounds");

        RaceResult roundResult = raceProgressManager.createRaceResult();
        assertThat(roundResult).isNotNull();
        assertThat(roundResult.raceProgress()).containsKeys("벤츠", "볼보");

        assertThat(roundResult.raceProgress().values()).allMatch(progress -> progress >= 0);
    }

    @Test
    @DisplayName("우승자 결정 및 출력 테스트")
    void 우승자_출력_테스트() throws Exception {
        invokePrivateMethod("startRace");

        RaceResult finalResult = raceProgressManager.createRaceResult();
        List<String> winners = winnerDecider.determineWinners(finalResult);

        assertThat(winners).isNotEmpty();
        assertThat(winners).containsAnyOf("벤츠", "볼보");
    }

    @Test
    @DisplayName("단일 라운드 실행 테스트")
    void 단일_라운드_실행_테스트() throws Exception {
        invokePrivateMethod("runSingleRound");

        RaceResult singleRoundResult = raceProgressManager.createRaceResult();
        assertThat(singleRoundResult).isNotNull();
        assertThat(singleRoundResult.raceProgress()).containsKeys("벤츠", "볼보");

        assertThat(singleRoundResult.raceProgress().values()).allMatch(progress -> progress >= 0);
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = RaceController.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(raceController);
    }
}

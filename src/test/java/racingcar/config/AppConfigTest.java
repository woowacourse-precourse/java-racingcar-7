package racingcar.config;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class AppConfigTest {

    private AppConfig appConfig;

    @BeforeEach
    void setUp() {
        appConfig = AppConfig.getInstance();
    }

    @Test
    @DisplayName("싱글톤_인스턴스_테스트")
    void testSingletonInstance() {
        assertSimpleTest(() -> {
            AppConfig instance1 = AppConfig.getInstance();
            AppConfig instance2 = AppConfig.getInstance();

            assertNotNull(instance1);
            assertNotNull(instance2);
            assertSame(instance1, instance2);
        });
    }

    @Test
    @DisplayName("InputController_생성_테스트")
    void testInputController() {
        assertSimpleTest(() -> {
            InputController inputController = appConfig.getInputController();
            assertNotNull(inputController);
        });
    }

    @Test
    @DisplayName("RaceController_생성_테스트")
    void testRaceController() {
        assertSimpleTest(() -> {
            RaceController raceController = appConfig.getRaceController();
            assertNotNull(raceController);
        });
    }

    @Test
    @DisplayName("RaceService_생성_테스트")
    void testRaceService() {
        assertSimpleTest(() -> {
            RaceService raceService = appConfig.getRaceService();
            assertNotNull(raceService);
        });
    }

    @Test
    @DisplayName("InputView_생성_테스트")
    void testInputView() {
        assertSimpleTest(() -> {
            InputView inputView = appConfig.getInputView();
            assertNotNull(inputView);
        });
    }

    @Test
    @DisplayName("OutputView_생성_테스트")
    void testOutputView() {
        assertSimpleTest(() -> {
            OutputView outputView = appConfig.getOutputView();
            assertNotNull(outputView);
        });
    }
}
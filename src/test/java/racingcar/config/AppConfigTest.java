package racingcar.config;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
    void testInputController() {
        assertSimpleTest(() -> {
            InputController inputController = appConfig.getInputController();
            assertNotNull(inputController);
        });
    }

    @Test
    void testRaceController() {
        assertSimpleTest(() -> {
            RaceController raceController = appConfig.getRaceController();
            assertNotNull(raceController);
        });
    }

    @Test
    void testRaceService() {
        assertSimpleTest(() -> {
            RaceService raceService = appConfig.getRaceService();
            assertNotNull(raceService);
        });
    }

    @Test
    void testInputView() {
        assertSimpleTest(() -> {
            InputView inputView = appConfig.getInputView();
            assertNotNull(inputView);
        });
    }

    @Test
    void testOutputView() {
        assertSimpleTest(() -> {
            OutputView outputView = appConfig.getOutputView();
            assertNotNull(outputView);
        });
    }
}
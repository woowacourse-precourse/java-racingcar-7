package racingcar.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;

class AppConfigTest {
    private final AppConfig appConfig = new AppConfig();

    @Test
    void appConfig_싱글톤_테스트() {
        AppConfig appConfig1 = AppConfig.getAppConfig();
        AppConfig appConfig2 = AppConfig.getAppConfig();
        assertThat(appConfig1).isSameAs(appConfig2);
    }

    @Test
    void gameController_정상_생성() {
        GameController gameController = appConfig.gameController();
        assertThat(gameController).isNotNull();
    }

    @Test
    void gameController_싱글톤_테스트() {
        GameController gameController1 = appConfig.gameController();
        GameController gameController2 = appConfig.gameController();
        assertThat(gameController1).isSameAs(gameController2);
    }
}
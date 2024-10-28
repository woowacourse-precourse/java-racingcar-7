package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RaceService;

@DisplayName("GameController 통합 테스트")
public class GameControllerIntegrationTest extends NsTest {
    @Test
    @DisplayName("GameController 는 경주를 성공적으로 초기화하고 진행한다")
    void gameControllerShouldInitializeRaceAndMoveCars() {
        run("Car1,Car2", "5");

        assert output().contains("경주 초기화 완료");
    }

    @Override
    protected void runMain() {
        RaceService raceService = new RaceService();
        RaceController controller = new RaceController(raceService);
        controller.start();
    }
}

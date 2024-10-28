package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.strategy.AlwaysMoveStrategy;
import racingcar.model.car.strategy.RandomMoveStrategy;
import racingcar.model.race.Race;
import racingcar.service.RaceService;

@DisplayName("GameController 통합 테스트")
public class RaceControllerIntegrationTest extends NsTest {
    @Test
    @DisplayName("두 명 이상의 우승자가 나오는 상황 테스트")
    void shouldReturnMultipleWinnersWhenTied() {
        List<Car> cars = List.of(
                new Car("Car1", new AlwaysMoveStrategy()),
                new Car("Car2", new AlwaysMoveStrategy())
        );

        Race race = new Race(cars);
        race.moveCars();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("Car1", "Car2");
    }

    @Test
    @DisplayName("잘못된 입력 발생 시 예외 처리 테스트")
    void shouldThrowExceptionForInvalidInputDuringRace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("Car1!", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 알파벳과 숫자만 포함해야 합니다.")
        );
    }

    @Test
    @DisplayName("AlwaysMoveStrategy 사용 시 우승자 출력 테스트")
    void shouldPrintFinalWinnersWithAlwaysMoveStrategy() {
        RaceService raceService = new RaceService();
        raceService.initializeRace(
                new String[]{"Car1", "Car2"},
                new AlwaysMoveStrategy(),
                5
        );
        raceService.moveCars();

        List<String> winners = raceService.getWinners();
        assertThat(winners).contains("Car1", "Car2");
    }

    @Test
    @DisplayName("RandomMoveStrategy 사용 시 레이스 결과 테스트 (우승자 임의)")
    void shouldHandleRandomMoveStrategyResults() {
        RaceService raceService = new RaceService();
        raceService.initializeRace(
                new String[]{"Car1", "Car2"},
                new RandomMoveStrategy(),
                5
        );

        raceService.moveCars();
        List<String> winners = raceService.getWinners();
        assertThat(winners).isNotEmpty();
    }

    @Override
    protected void runMain() {
        RaceService raceService = new RaceService();
        RaceController controller = new RaceController(raceService);
        controller.start();
    }
}

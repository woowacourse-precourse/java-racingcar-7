package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayName("RacingGame 클래스의 기능 테스트")
public class RacingGameTest {

    @Nested
    @DisplayName("게임 생성 테스트")
    class CreateGameTest {

        @Test
        @DisplayName("유효한 자동차 이름 리스트와 이동 횟수로 게임을 생성할 수 있어야 한다.")
        void shouldCreateRacingGameWithValidInputs() {
            List<String> names = Arrays.asList("pobi", "crong");
            int moveCount = 5;
            MoveStrategy moveStrategy = new RandomMoveStrategy(new FixedRandomGenerator(4));

            RacingGame racingGame = new RacingGame(names, moveCount, moveStrategy);
            assertThat(racingGame).isNotNull();
        }
    }

    @Nested
    @DisplayName("게임 진행 테스트")
    class StartGameTest {

        @Test
        @DisplayName("게임 진행 시 각 자동차는 전진 전략에 따라 이동해야 한다.")
        void startRaceShouldMoveCarsAccordingToMoveStrategy() {
            List<String> names = Arrays.asList("pobi", "crong");
            int moveCount = 3;
            MoveStrategy moveStrategy = new RandomMoveStrategy(new FixedRandomGenerator(4));

            RacingGame racingGame = new RacingGame(names, moveCount, moveStrategy);
            racingGame.startRace();

            List<Car> cars = racingGame.getCars();
            for (Car car : cars) {
                assertThat(car.getPosition()).isEqualTo(3);
            }
        }
    }
}

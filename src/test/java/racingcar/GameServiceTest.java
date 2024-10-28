package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    private final Integer ROUND = 5;
    private GameService gameService;
    private List<String> racingCarsName;

    @BeforeEach
    public void setUp() {
        gameService  = new GameService();
        racingCarsName = new ArrayList<>();
        racingCarsName.add("woodz");
        racingCarsName.add("yuze");
        racingCarsName.add("karina");
    }

    @Nested
    @DisplayName("게임 로직을 실행합니다.")
    class ExecuteLogicTest {
        @Test
        void 게임핵심로직을_실행합니다() {
            // when
            gameService.init(ROUND, racingCarsName);
            List<RacingCar> racingCars = gameService.executeLogic();

            // then
            assertNotNull(racingCars);
        }
    }

    @Nested
    @DisplayName("게임을 초기화 합니다.")
    class InitGameTest {
        @Test
        void 게임을_초기화합니다() {
            // when
            gameService.init(ROUND, racingCarsName);

            // then
            assertThat(gameService.getGame().getRound()).isEqualTo(ROUND);
            assertThat(gameService.getGame().getRacingCars().size()).isEqualTo(racingCarsName.size());
        }

        @Test
        void 차를_초기화합니다() {
            // when
            List<RacingCar> racingCars = gameService.createRacingCars(racingCarsName);

            // then
            for (int i = 0; i < racingCars.size(); i++) {
                assertThat(racingCars.get(i).getScore()).isEqualTo(0);
                assertThat(racingCars.get(i).getName()).isEqualTo(racingCarsName.get(i));
            }
        }
    }

    @Nested
    @DisplayName("selectWinner()를 테스트합니다.")
    class SelectWinnerTest {
        @Test
        void score가_가장_높은사람이_1명일_경우_우승자는_1명이다() {
            // given
            gameService.init(ROUND, racingCarsName);
            gameService.getGame().getRacingCars().get(0).addScore();

            // when
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners).containsExactlyInAnyOrder("woodz");
        }

        @Test
        void score가_가장_높은사람이_2명일_경우_우승자는_2명이다() {
            // given
            gameService.init(ROUND, racingCarsName);
            gameService.getGame().getRacingCars().get(0).addScore();
            gameService.getGame().getRacingCars().get(1).addScore();

            // when
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners).containsExactlyInAnyOrder("woodz", "yuze");
        }

        @Test
        void 참가자의_score가_모두_동일하면_우승자는_전체이다() {
            // given
            gameService.init(ROUND, racingCarsName);
            for (RacingCar car : gameService.getGame().getRacingCars()) {
                car.addScore();
            }

            // when
            List<String> winners = gameService.selectWinner();

            // then
            assertThat(winners).containsExactlyInAnyOrder("woodz", "yuze", "karina");
        }
    }
}
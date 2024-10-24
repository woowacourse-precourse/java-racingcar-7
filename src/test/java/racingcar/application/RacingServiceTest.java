package racingcar.application;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarState;
import racingcar.domain.ScoreBoard;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService(() -> true); // 무조건 움직임
    }

    @Test
    @DisplayName("getRacingResult 메서드를 호출하면 예상한 결과값을 반환한다.")
    void getRacingResult() {
        ScoreBoard scoreBoard = racingService.getRacingResult("car1,car2", "3");

        assertSoftly(softly -> {
            softly.assertThat(scoreBoard.roundScoresList()).hasSize(3);
            softly.assertThat(scoreBoard.winners()).containsExactly("car1", "car2");

            // 각 라운드의 상태 검증
            softly.assertThat(scoreBoard.roundScoresList().get(0).carStates()).containsExactly(
                    new CarState("car1", 1),
                    new CarState("car2", 1)
            );
            softly.assertThat(scoreBoard.roundScoresList().get(1).carStates()).containsExactly(
                    new CarState("car1", 2),
                    new CarState("car2", 2)
            );
            softly.assertThat(scoreBoard.roundScoresList().get(2).carStates()).containsExactly(
                    new CarState("car1", 3),
                    new CarState("car2", 3)
            );
        });
    }
}
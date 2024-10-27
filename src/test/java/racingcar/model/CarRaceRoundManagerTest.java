package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 라운드 관리자 테스트")
class CarRaceRoundManagerTest {

    @Test
    @DisplayName("1 이하의 수를 진행하려는 경우 예외 발생 테스트")
    void should_ThrowException_WhenRoundLessThan1() {
        int roundCount = 0;

        assertThatThrownBy(() -> new CarRaceRoundManager(roundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지정된 라운드 수를 초과하여 진행하는 경우 예외 발생 테스트")
    void should_ThrowException_WhenExceedingMaxRounds() {
        int roundCount = 3;
        CarRaceRoundManager roundManager = new CarRaceRoundManager(roundCount);

        assertThatThrownBy(() -> {
            for (int i = 0; i < roundCount + 1; i++) {
                roundManager.nextRound();
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("지정된 수만큼 라운드를 진행할 수 있다.")
    void should_ProceedToNextRound_WhenRoundsAreAvailable() {
        int roundCount = 5;
        CarRaceRoundManager roundManager = new CarRaceRoundManager(roundCount);

        for (int i = 0; i < roundCount; i++) {
            roundManager.nextRound();
        }

        assertThat(roundManager.hasMoreRounds()).isFalse();
    }

    @Test
    @DisplayName("첫 번째 상태에서는 라운드가 진행 가능하다.")
    void should_ReturnTrue_WhenRoundsAreAvailableInitially() {
        CarRaceRoundManager roundManager = new CarRaceRoundManager(1);

        assertThat(roundManager.hasMoreRounds()).isTrue();
    }

    @Test
    @DisplayName("모든 라운드를 진행한 후에는 더 이상 라운드가 존재하지 않는다.")
    void should_ReturnFalse_WhenAllRoundsAreCompleted() {
        int roundCount = 2;
        CarRaceRoundManager roundManager = new CarRaceRoundManager(roundCount);

        roundManager.nextRound();
        roundManager.nextRound();

        assertThat(roundManager.hasMoreRounds()).isFalse();
    }
}

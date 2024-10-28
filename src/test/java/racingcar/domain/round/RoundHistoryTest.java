package racingcar.domain.round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundHistoryTest {

    List<RoundResult> roundResult;
    RoundHistory roundHistory;
    RoundSnapshot roundSnapshot;    // Default round snapshot

    @BeforeEach
    void setUp() {
        roundHistory = new RoundHistory();
        roundResult = new ArrayList<>();
        roundResult.add(new RoundResult("car1", 1));
        roundResult.add(new RoundResult("car2", 2));
        roundResult.add(new RoundResult("car3", 3));
        roundSnapshot = new RoundSnapshot(roundResult);
    }

    @Test
    @DisplayName("라운드 정보를 추가 한 경우, 라운드 정보의 상세 내역을 알 수 있다.")
    void givenRoundResultSnapshot_whenAddRoundResult_ThenRoundSnapshotHasSizeThree() {
        // given
        RoundSnapshot roundSnapshot = new RoundSnapshot(List.of(roundResult.getFirst()));

        // when
        roundHistory.addRoundSnapshot(1, roundSnapshot);

        // then
        RoundResult result = roundHistory.getRoundResult(1).getFirst();
        assertThat(result.carName()).isEqualTo("car1");
        assertThat(result.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("3개의 라운드 정보를 추가 한 경우, 3개의 라운드 정보를 가져온다.")
    void givenDefaultRoundSnapshot_whenAddRoundResult_ThenRoundSnapshotHasSizeThree() {
        // given
        // when
        roundHistory.addRoundSnapshot(1, roundSnapshot);

        // then
        List<RoundResult> result = roundHistory.getRoundResult(1);
        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("시작되지 않은 라운드 정보를 가져오면 예외가 발생한다.")
    void givenNothing_whenGetRoundResult_thenThrowException() {
        // given
        // when & then
        assertThatThrownBy(() -> roundHistory.getRoundResult(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
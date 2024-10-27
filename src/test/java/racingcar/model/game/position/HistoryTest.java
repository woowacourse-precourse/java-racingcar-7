package racingcar.model.game.position;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Position;
import racingcar.model.game.position.Positions;

@DisplayName("경기 기록 테스트")
class HistoryTest {

    @Nested
    @DisplayName("추가 테스트")
    class addTest {
        @Test
        @DisplayName("History에 위치 정보를 추가한다")
        void 성공_원소추가() {
            // Given
            History history = new History(Collections.emptyList());
            Positions positions = new Positions(List.of(new Position(0)));

            // When
            history.add(positions);

            // Then
            assertThat(history.values()).contains(positions);
        }
    }
}

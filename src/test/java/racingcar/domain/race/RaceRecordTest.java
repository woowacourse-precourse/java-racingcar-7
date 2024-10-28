package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RaceRecordTest {

    @Test
    @DisplayName("null exception 테스트")
    void testNullException() {
        assertThatThrownBy(() -> new RaceRecord(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("raceRoundRecords가 null입니다");
    }
}
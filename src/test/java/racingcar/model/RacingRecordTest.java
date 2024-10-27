package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingRecordTest {

    private final RacingRecord racingRecord = new RacingRecord(new Car("pobi"));

    @DisplayName("RacingRecord_생성_테스트")
    @Test
    public void newRacingRecordTest() {
        //given
        //when
        //then
        assertThat(racingRecord).isNotNull();
        assertThat(racingRecord)
                .extracting("moveDistance")
                .isEqualTo(0);
        assertThat(racingRecord)
                .extracting("car")
                .extracting("name")
                .isEqualTo("pobi");
    }

    @DisplayName("움직임_기록_테스트")
    @Test
    void recordMovementTest() {
        //given
        List<Integer> trueMovement = List.of(0, 1, 1, 2);

        int moveNumber = 4;
        int stopNumber = 3;
        List<Integer> racingRounds = List.of(moveNumber, stopNumber, moveNumber);
        List<Integer> roundRecords = new ArrayList<>();
        //when
        roundRecords.add(racingRecord.getMoveDistance());
        for (int roundNumber : racingRounds) {
            racingRecord.recordMovement(roundNumber);
            roundRecords.add(racingRecord.getMoveDistance());
        }
        //then
        assertThat(roundRecords).isEqualTo(trueMovement);
    }

    @DisplayName("이동거리_조회_테스트")
    @Test
    public void getMoveDistanceTest() {
        //given
        //when
        int moveDistance = racingRecord.getMoveDistance();
        //then
        assertThat(racingRecord)
                .extracting("moveDistance")
                .isEqualTo(moveDistance);
    }
}
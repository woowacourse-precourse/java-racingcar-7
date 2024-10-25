package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgmentTest {

    private MovementRecord movementRecord;
    private Judgment judgment;

    @BeforeEach
    void setUp() {
        movementRecord = new MovementRecord();
        judgment = new Judgment(movementRecord);
    }

    @Test
    @DisplayName("최종 우승자가 한 명일 경우 반환한다.")
    void getWinner() {
        Cars cars = new Cars(List.of("pobi", "kiki", "jun"));
        cars.updateCarPosition("pobi");
        movementRecord.recordRound(cars);

        List<String> winners = judgment.getWinners();
        assertEquals(List.of("pobi"), winners);
    }

    @Test
    @DisplayName("최종 우승자가 여러 명일 경우 반환한다.")
    void getWinners() {
        Cars cars = new Cars(List.of("pobi", "kiki", "jun"));
        cars.updateCarPosition("pobi");
        cars.updateCarPosition("kiki");
        movementRecord.recordRound(cars);

        List<String> winners = judgment.getWinners();
        assertEquals(List.of("pobi", "kiki"), winners);
    }

}

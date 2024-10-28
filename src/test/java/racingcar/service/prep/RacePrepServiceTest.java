package racingcar.service.prep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.Registration;

class RacePrepServiceTest {

    private List<String> lineup = List.of("test1", "test2");
    private Long lapCount = 1L;

    private Registration registration() {
        return new Registration(lineup, lapCount);
    }

    @Test
    @DisplayName("경기 생성 테스트 자동차 이름")
    void carNames() {
        RacePrepService racePrepService = new RacePrepService();
        Race testRace = racePrepService.prepare(registration());

        List<String> actual
                = testRace.getEntry()
                .stream()
                .map(Car::getName)
                .toList();

        assertEquals(lineup, actual);
    }

    @Test
    @DisplayName("경기 생성 테스트 lapCount")
    void lapCount() {
        RacePrepService racePrepService = new RacePrepService();
        Race testRace = racePrepService.prepare(registration());

        Long actual = testRace.getLapLefts();

        assertEquals(lapCount, actual);
    }
}
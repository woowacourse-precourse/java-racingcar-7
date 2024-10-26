package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {
    @Test
    @DisplayName("주어진 횟수만큼 경주 진행되는지 테스트")
    void 주어진_횟수만큼_경주_진행() {
        // given
        String[] carNames = {"pobi", "woni", "jun"};
        int attemptCount = 5; // 경주 시도 횟수

        // when
        Race race = new Race(carNames, attemptCount);
        race.start();

        // then
        assertEquals(attemptCount, race.getAttemptCount());
    }

    @Test
    @DisplayName("자동차가 무작위로 전진하거나 멈추는지 테스트")
    void 자동차가_무작위로_전진하거나_멈춤() {
        // given
        String[] carNames = {"pobi", "woni", "jun"};
        int attemptCount = 5; // 경주 시도 횟수

        // when
        Race race = new Race(carNames, attemptCount);
        race.start();

        // then
        for (String carName : carNames) {
            int position = race.getCarPosition(carName);
            assertTrue(position >= 0 && position <= attemptCount);
        }
    }

    @Test
    @DisplayName("경주할 자동차가 없을 경우 예외 발생 테스트")
    void 경주할_자동차가_없을_경우_예외_발생() {
        // given
        String[] carNames = {}; // 자동차가 없음
        int attemptCount = 5;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            Race race = new Race(carNames, attemptCount);
            race.start();
        });
    }
}
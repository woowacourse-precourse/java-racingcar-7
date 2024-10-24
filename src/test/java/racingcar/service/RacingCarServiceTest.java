package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestUtils;
import racingcar.util.RandomNumberGenerator;

public class RacingCarServiceTest {


    @Test
    @DisplayName("3개 자동차가 2번 이동한 결과를 확인한다.")
    void runTwoRounds() {
        // Given
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(List.of(4, 3, 2));
        RacingCarService racingCarService = new RacingCarService(randomNumberGenerator);
        String[] carNames = new String[]{"a", "b", "c"};
        int rounds = 2;

        // When
        String[] raceResult = racingCarService.run(carNames, rounds);

        // Then
        assertArrayEquals(new String[]{"a"}, raceResult);
    }

    @Test
    @DisplayName("3개 자동차가 5번 이동한 결과를 확인한다.")
    void runFiveRounds() {
        // Given
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(List.of(3, 9, 2));
        RacingCarService racingCarService = new RacingCarService(randomNumberGenerator);
        String[] carNames = new String[]{"a", "b", "c"};
        int rounds = 5;

        // When
        String[] raceResult = racingCarService.run(carNames, rounds);

        // Then
        assertArrayEquals(new String[]{"b"}, raceResult);
    }

    @Test
    @DisplayName("3개 자동차가 5번 이동한 결과를 확인한다.")
    void runFiveRoundsTwoWinner() {
        // Given
        RandomNumberGenerator randomNumberGenerator = TestUtils.mockRandomNumberGenerator(List.of(3, 9, 4));
        RacingCarService racingCarService = new RacingCarService(randomNumberGenerator);
        String[] carNames = new String[]{"a", "b", "c"};
        int rounds = 5;

        // When
        String[] raceResult = racingCarService.run(carNames, rounds);

        // Then
        assertArrayEquals(new String[]{"b", "c"}, raceResult);
    }

}

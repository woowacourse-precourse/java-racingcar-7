package racingcar.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarServiceTest {

    private RandomNumberGenerator mockRandomNumberGenerator(List<Integer> preDefinedNumbers) {
        return new RandomNumberGenerator() {
            private int index = 0;

            @Override
            public int pickRandomNumberInRange(int start, int end) {
                int value = preDefinedNumbers.get(index);
                index = (index + 1) % preDefinedNumbers.size();
                return value;
            }
        };
    }


    @Test
    @DisplayName("3개 자동차가 2번 이동한 결과를 확인한다.")
    void runTwoRounds() {
        // Given
        RandomNumberGenerator randomNumberGenerator = mockRandomNumberGenerator(List.of(4, 3, 2));
        RacingCarService racingCarService = new RacingCarService(randomNumberGenerator);
        String userCarInput = "a,b,c";
        String userRoundInput = "2";

        // When
        String raceResult = racingCarService.run(userCarInput, userRoundInput);

        // Then
        Assertions.assertEquals("a", raceResult);
    }

    @Test
    @DisplayName("3개 자동차가 5번 이동한 결과를 확인한다.")
    void runFiveRounds() {
        // Given
        RandomNumberGenerator randomNumberGenerator = mockRandomNumberGenerator(List.of(3, 9, 2));
        RacingCarService racingCarService = new RacingCarService(randomNumberGenerator);
        String userCarInput = "a,b,c";
        String userRoundInput = "5";

        // When
        String raceResult = racingCarService.run(userCarInput, userRoundInput);

        // Then
        Assertions.assertEquals("b", raceResult);
    }

}

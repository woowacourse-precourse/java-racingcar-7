package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.service.RandomNumbersGenerator;

public class RandomNumbersGeneratorTest {
    private static final int CAR_COUNT = 4;
    private static RandomNumbersGenerator randomNumbersGenerator;

    @BeforeAll
    static void initializeGenerator() {

        //given
        randomNumbersGenerator = new RandomNumbersGenerator();
    }

    private RandomNumbers generateRandomNumbers() {

        //when
        return randomNumbersGenerator.generate(CAR_COUNT);
    }

    @Test
    @DisplayName("generate(carCount)로 생성된 RandomNumbers의 size()는 carCount와 동일하다.")
    void shouldHaveCorrectSizeWhenGeneratedWithCarCount() {

        //given
        RandomNumbers randomNumbers = generateRandomNumbers();

        //then
        assertEquals(CAR_COUNT, randomNumbers.size());
    }

    @RepeatedTest(100)
    @DisplayName("generate(carCount)로 생성된 RandomNumbers의 각 값은 0 이상 9 이하이다.")
    void eachGeneratedNumberShouldWithinRange() {

        //given
        RandomNumbers randomNumbers = generateRandomNumbers();

        for (int i = 0; i < CAR_COUNT; i++) {

            //when
            int randomNumber = randomNumbers.getNextNumber();

            //then
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}

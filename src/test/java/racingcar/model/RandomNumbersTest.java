package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    private static RandomNumbers randomNumbers;
    private static final List<Integer> TEST_NUMBERS = List.of(1, 2, 3, 4);

    @BeforeAll
    static void InitializeRandomNumbers() {

        //given
        randomNumbers = RandomNumbers.create(TEST_NUMBERS);
    }

    @Test
    @DisplayName("randomNumbers의 size()는 리스트 크기와 동일해야 한다.")
    void shouldReturnCorrectRandomNumbersSizeWhenCreateWithSize() {

        //when
        int expectedSize = randomNumbers.size();

        //then
        assertEquals(expectedSize, randomNumbers.size());
    }

    @Test
    @DisplayName("getNextNumber()는 리스트의 각 숫자를 순서대로 반환해야 한다.")
    void shouldReturnCorrectRandomNumbersWhenGetNextNumber() {

        //then-then
        TEST_NUMBERS.forEach(expected -> assertEquals(expected, randomNumbers.getNextNumber()));
    }
}
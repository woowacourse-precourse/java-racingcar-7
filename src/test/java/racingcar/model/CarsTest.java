package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void initializeCars() {

        // given
        cars = Cars.create(List.of("jiho", "sumi").toArray(new String[0]));
    }

    @Test
    @DisplayName("jiho라는 Car가 4의 랜덤 숫자를 할당받을 때, 'jiho : -'가 출력돼야 함")
    public void shouldPrintResultForJihoWithRandomNumberFour() {
        checkCarOutputWithRandomNumbers("jiho : -", List.of(4, 1));
    }

    @Test
    @DisplayName("sumi라는 Car가 1의 랜덤 숫자를 할당받을 때, 'sumi : '가 출력돼야 함")
    public void shouldPrintResultForSumiWithRandomNumberOne() {
        checkCarOutputWithRandomNumbers("sumi : ", List.of(4, 1));
    }

    @Test
    @DisplayName("2개의 Car가 있을 때, size() 시 2를 반환해야 함")
    public void shouldReturnCorrectValueWhenTwoCarExist() {

        // when
        int carCount = cars.count();

        //then
        assertEquals(2, carCount);
    }

    @Test
    @DisplayName("jiho라는 Car가 position이 더 클 때 jiho(String)를 반환해야 함")
    public void shouldReturnCorrectCarsWhenGetTopRanker() {

        //given
        cars.moveEach(RandomNumbers.create(List.of(4, 1)));

        //when
        List<String> topRankers = cars.findTopRankers();

        //then
        assertEquals(List.of("jiho"), topRankers);
    }

    private void checkCarOutputWithRandomNumbers(String expectedOutput, List<Integer> randomNumbersList) {

        //given
        RandomNumbers randomNumbers = RandomNumbers.create(randomNumbersList);

        //when
        StringBuilder results = new StringBuilder();
        results.append(cars.moveEach(randomNumbers)).append("\n");

        //then
        assertTrue(results.toString().contains(expectedOutput));
    }
}
package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceServiceTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 저장한다.")
    void should_InitializeCars_When_GivenCommaSeparatedNames() {
        //given
        String input = "foo,bar";
        CarRaceService carRaceService = new CarRaceService();

        //when
        carRaceService.init(input);

        //then
        Set<String> carNames = carRaceService.getCarsStatus().keySet();
        assertEquals(2L, carNames.size());
        assertTrue(carNames.contains("foo"));
        assertTrue(carNames.contains("bar"));
    }
}
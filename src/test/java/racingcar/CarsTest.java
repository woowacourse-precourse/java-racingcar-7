package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 생성")
    void 자동차_추가() {
        //given
        Set<String> input = Set.of("pobi","ddot");
        //when
        Cars cars = new Cars(input);
        //then
        assertEquals(input, cars.keySet());
    }

    
}
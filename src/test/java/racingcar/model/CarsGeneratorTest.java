package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsGeneratorTest {

    @DisplayName("차량_생성_테스트")
    @Test
    void generateFromTest() {
        //given
        String names = "pobi,woni,jun";
        //when
        List<Car> cars = CarsGenerator.generateFrom(names);
        //then
        assertThat(cars)
                .extracting("name")
                .containsExactly("pobi", "woni", "jun");
    }
}
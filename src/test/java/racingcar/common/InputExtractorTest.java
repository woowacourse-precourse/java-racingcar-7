package racingcar.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.InputExtractor;

import java.util.List;

class InputExtractorTest {

    InputExtractor inputExtractor = new InputExtractor();

    @Test
    void 하나의_자동차_추출() {
        //given
        String input = "woody";

        //when
        List<Car> cars = inputExtractor.extractCars(input);

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("woody");
        Assertions.assertThat(cars.get(0).getForwardLevel()).isEqualTo(0);
    }

    @Test
    void 여러대의_자동차_추출() {
        //given
        String input = "woody,fobi";

        //when
        List<Car> cars = inputExtractor.extractCars(input);

        //then
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("woody");
        Assertions.assertThat(cars.get(0).getForwardLevel()).isEqualTo(0);

        Assertions.assertThat(cars.get(1).getName()).isEqualTo("fobi");
        Assertions.assertThat(cars.get(1).getForwardLevel()).isEqualTo(0);
    }

}
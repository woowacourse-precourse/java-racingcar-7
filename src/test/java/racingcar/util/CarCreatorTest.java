package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarCreatorTest {
    @Test
    void creator_자동차_객체_생성() {
        String input = "pobi,woni";
        List<String> splitInput = CarNameSeparator.splitCarNameWithoutSpace(input);
        List<Car> result = CarsCreator.createCarNameToCar(splitInput);

        assertThat(result.get(0).getCarName()).isEqualTo("pobi");
        assertThat(result.get(1).getCarName()).isEqualTo("woni");
    }
}

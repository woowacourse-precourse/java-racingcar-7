package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.model.ExceptionMessages.Cars.DUPLICATE_CAR_NAME;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

public class CarsTest {

    @Test
    @DisplayName("중복된 이름을 입력하는 경우 예외가 발생한다.")
    void throwExceptionWhenNamesAreDuplicated() {
        // given
        String name = "pobi";
        String[] duplicatedNames = {name, name, name};

        // when & then
        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME);
    }

}

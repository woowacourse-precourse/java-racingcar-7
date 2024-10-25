package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("중복된 자동차 이름이 입력되었을 때 예외가 발생해야 한다")
    void duplicateNames() {
        String duplicateNames = "pobi,woni,pobi";

        assertThatThrownBy(() -> new Cars(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

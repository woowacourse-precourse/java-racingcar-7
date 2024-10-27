package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 목록 객체 테스트")
class CarsTest {

    @Test
    @DisplayName("중복되는 자동차 이름이 있는 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNamesDuplicate() {
        List<String> testCarNames = List.of("pobi", "pobi");
        assertThatThrownBy(() -> new Cars(testCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 규칙에 부합하는 경우 객체가 생성된다.")
    void createsCarObject_When_CarNamesAreValid() {
        List<String> testCarNames = List.of("pobi", "woni");
        Cars testCars = new Cars(testCarNames);

        List<Car> cars = testCars.getCars();
        assertEquals(testCarNames.size(), cars.size());
        assertEquals(testCarNames.get(0), cars.get(0).getName());
        assertEquals(testCarNames.get(1), cars.get(1).getName());
    }
}

package racingcar;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {

    @Test
    void createCars_입력된_이름으로_자동차_목록_생성() {
        // Given
        List<String> carNames = List.of("pobi", "crong", "honux");

        // When
        List<Car> cars = createCars(carNames);

        // Then
        assertThat(cars).hasSize(carNames.size());
        assertThat(cars).extracting(Car::getName)
                .containsExactlyElementsOf(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
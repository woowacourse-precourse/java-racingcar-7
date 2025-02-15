package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void carsCreation_withValidNames_shouldInitializeAllCars() {
        List<String> names = Arrays.asList("car1", "car2", "car3");
        Cars cars = new Cars(names);
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    public void carsCreation_withEmptyName_shouldThrowException() {
        List<String> names = Arrays.asList("car1", "", "car3");
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    public void carsCreation_withNullList_shouldThrowException() {
        assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 하나 이상 입력해야 합니다.");
    }

    @Test
    public void getWinners_shouldReturnCarWithMaxPosition() {
        List<String> names = Arrays.asList("car1", "car2", "car3");
        Cars cars = new Cars(names);

        // Manually set positions
        cars.getCars().get(0).move(4); // car1 position 1
        cars.getCars().get(1).move(5); // car2 position 1
        cars.getCars().get(2).move(6); // car3 position 1

        // car2 moves one more time
        cars.getCars().get(1).move(4); // car2 position 2

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("car2");
    }

    @Test
    public void getWinners_withMultipleWinners_shouldReturnAllWinners() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        // Manually set positions
        cars.getCars().get(0).move(5); // pobi position 1
        cars.getCars().get(0).move(5); // pobi position 2
        cars.getCars().get(1).move(4); // woni position 1
        cars.getCars().get(2).move(5); // jun position 1
        cars.getCars().get(2).move(5); // jun position 2

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}

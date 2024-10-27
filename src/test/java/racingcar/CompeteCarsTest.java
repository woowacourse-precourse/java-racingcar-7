package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CompeteCarsTest {
    @Test
    void duplicatedCarTest() {
        assertThatThrownBy(() -> new CompeteCars(List.of("test", "test")));
    }

    @Test
    void getAllTest() {
        Car car1 = new Car("One");
        Car car2 = new Car("Two");
        Car car3 = new Car("Three");
        CompeteCars competeCars = new CompeteCars(List.of("One", "Two", "Three"));

        assertThat(competeCars.getAll()).containsExactly(car1, car2, car3);
    }
}
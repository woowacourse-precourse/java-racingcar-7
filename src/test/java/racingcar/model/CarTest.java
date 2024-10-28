package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void should_CreateCar_When_NameIsValid() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getProgress()).isZero();
    }

    @Test
    void should_ThrowException_When_NameIsEmpty() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어 있으면 안됩니다.");
    }

    @Test
    void should_ThrowException_When_NameIsNull() {
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어 있으면 안됩니다.");
    }

    @Test
    void should_ThrowException_When_NameIsTooLong() {
        String longName = "abcdef";
        assertThatThrownBy(() -> new Car(longName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void should_MoveForward_When_CanMoveIsTrue() {
        Car car = new Car("pobi");
        MoveStrategy alwaysMoveStrategy = () -> true;
        car.move(alwaysMoveStrategy);
        assertThat(car.getProgress()).isEqualTo(1);
    }

    @Test
    void should_NotMove_When_CanMoveIsFalse() {
        Car car = new Car("pobi");
        MoveStrategy neverMoveStrategy = () -> false;
        car.move(neverMoveStrategy);
        assertThat(car.getProgress()).isEqualTo(0);
    }

    @Test
    void should_ReturnCorrectVisualization() {
        Car car = new Car("pobi");
        MoveStrategy alwaysMoveStrategy = () -> true;
        car.move(alwaysMoveStrategy);
        car.move(alwaysMoveStrategy);
        String visualization = car.visualizeProgress();
        assertThat(visualization).isEqualTo("pobi : --");
    }

}

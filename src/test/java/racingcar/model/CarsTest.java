package racingcar.model;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void should_CreateCars_When_CarNamesAreValid() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(carNames);
        assertThat(cars).isNotNull();
    }

    @Test
    void should_ThrowException_When_CarNamesAreDuplicated() {
        List<String> carNames = Arrays.asList("pobi", "crong", "pobi");
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("동일한 자동차 이름이 중복될 수 없습니다.");
    }

    @Test
    void should_ThrowException_When_CarNameIsEmpty() {
        List<String> carNames = Arrays.asList("pobi", "", "honux");
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 비어 있으면 안됩니다.");
    }

    @Test
    void should_AllCarsMoveForward_When_CanMoveIsTrue() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(carNames);
        MoveStrategy alwaysMoveStrategy = () -> true;

        cars.moveCars(alwaysMoveStrategy);

        cars.getCars().forEach(car -> assertThat(car.getProgress()).isEqualTo(1));
    }

    @Test
    void should_AllCarsNotMove_When_CanMoveIsFalse() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(carNames);
        MoveStrategy neverMoveStrategy = () -> false;

        cars.moveCars(neverMoveStrategy);

        cars.getCars().forEach(car -> assertThat(car.getProgress()).isEqualTo(0));
    }

    @Test
    void should_ReturnSingleWinner_When_OneCarHasHighestProgress() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(carNames);
        MoveStrategy alwaysMoveStrategy = () -> true;
        MoveStrategy neverMoveStrategy = () -> false;

        cars.getCars().get(0).move(alwaysMoveStrategy); // pobi
        cars.getCars().get(1).move(neverMoveStrategy); // crong
        cars.getCars().get(2).move(neverMoveStrategy); // honux

        List<String> winners = cars.calculateWinners();

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void should_ReturnMultipleWinners_When_MultipleCarsHaveSameHighestProgress() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Cars cars = new Cars(carNames);
        MoveStrategy alwaysMoveStrategy = () -> true;

        cars.moveCars(alwaysMoveStrategy);

        List<String> winners = cars.calculateWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong", "honux");
    }

    @Test
    void should_CollectCorrectProgressVisualizations() {
        List<String> carNames = Arrays.asList("pobi", "crong");
        Cars cars = new Cars(carNames);
        MoveStrategy alwaysMoveStrategy = () -> true;

        cars.moveCars(alwaysMoveStrategy); // 진행도 1 증가
        List<String> visualizations = cars.collectProgressVisualizations();

        assertThat(visualizations).containsExactly("pobi : -", "crong : -");
    }
    
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    private String[] names;
    private Cars cars;
    private int attemptCount;

    @BeforeEach
    void setUp() {
        attemptCount = 3;
        names = new String[]{"pobi", "woni", "jun"};
        cars = new Cars(names);
        game = new Game(cars, attemptCount);
    }

    @Test
    @DisplayName("시도 횟수만큼 반복한 뒤에는 isRunning 이 false 를 반환한다.")
    void shouldReturnFalseAfterAttemptCountRepetitions() {
        // when
        for (int i = 0; i < attemptCount; i++) {
            game.play();
        }

        // then
        assertThat(game.isRunning()).isFalse();
    }

    @Test
    @DisplayName("시도 횟수만큼 반복하기 이전에는 isRunning 이 true 를 반환한다.")
    void shouldReturnTrueBeforeAttemptCountRepetitions() {
        // when
        for (int i = 0; i < attemptCount - 1; i++) {
            game.play();
        }

        // then
        assertThat(game.isRunning()).isTrue();
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차의 이름을 반환한다.")
    void returnNameOfCarWhenItHasMaxPosition() {
        // given
        int indexOfMaxPositionCar = 0;

        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);
        cars.move(indexOfMaxPositionCar);

        // when
        List<String> nameOfMaxPositionCars = game.getNameOfWinners();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(1),
                () -> assertThat(nameOfMaxPositionCars.get(indexOfMaxPositionCar)).isEqualTo(
                        names[indexOfMaxPositionCar])
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러대일 경우 여러개의 이름을 반환한다.")
    void returnNamesOfCarsWhenTheyHaveMaxPosition() {
        // given
        int indexOfFirstMaxPositionCar = 0;
        int indexOfSecondMaxPositionCar = 1;
        int sizeOfMaxPositionCars = 2;

        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfFirstMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);
        cars.move(indexOfSecondMaxPositionCar);

        // when
        List<String> nameOfMaxPositionCars = cars.getNameOfMaxPositionCars();

        // then
        assertAll(
                () -> assertThat(nameOfMaxPositionCars.size()).isEqualTo(sizeOfMaxPositionCars),
                () -> assertThat(nameOfMaxPositionCars).isEqualTo(
                        List.of(names[indexOfFirstMaxPositionCar], names[indexOfSecondMaxPositionCar]))
        );
    }
}

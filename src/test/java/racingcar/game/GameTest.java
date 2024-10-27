package racingcar.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.name.Name;
import racingcar.name.Names;
import racingcar.car.Car;
import racingcar.car.Cars;

class GameTest {

    private Cars cars;

    @BeforeEach
    void setUp(){
        Names names = new Names("a,bb,ccc");
        //List<Name> names = Arrays.asList(new Name("a"), new Name("bb"), new Name("ccc"));
        cars = new Cars(names);
    }

    @DisplayName("게임 시작 되었을 때, 라운드마다 차가 움직인다.")
    @Test
    void Given_StartGame_When_FinishGame_Then_IsNotEqual() {
        // Given
        int round = 3;
        List<Name> names = Arrays.asList(new Name("a"), new Name("bb"), new Name("ccc"));
        List<Car> initCars = cars.getCars(names);
        // When
        Game.start(cars, round);
        // Then
        List<Car> finishCars = cars.getCars(names);
        assertThat(initCars).isNotEqualTo(finishCars);
    }
}
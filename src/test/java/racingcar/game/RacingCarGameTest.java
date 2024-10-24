package racingcar.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarName;

class RacingCarGameTest {

    @Test
    void createRacingCarGame_게임횟수그리고자동차들입력받으면_생성한다(){
        // given
        final int loop = 3;

        final Car car1 = Car.createNamedCar("kim");
        final Car car2 = Car.createNamedCar("park");
        final List<Car> cars = List.of(car1, car2);

        // expect
        assertThatCode(() -> RacingCarGame.createLoopedRacingCarGame(loop,cars))
                .doesNotThrowAnyException();
    }
    @Test
    void createRacingCarGame_자동차최대5대초과시_예외처리(){
        // given
        final int loop = 3;

        final Car car1 = Car.createNamedCar("kim");
        final Car car2 = Car.createNamedCar("park");
        final Car car3 = Car.createNamedCar("lee");
        final Car car4 = Car.createNamedCar("cho");
        final Car car5 = Car.createNamedCar("go");
        final Car car6 = Car.createNamedCar("soo");
        final List<Car> fiveOverCars = List.of(car1, car2,car3,car4,car5,car6);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(loop,fiveOverCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 최대 5대까지 게임 가능합니다.");
    }

    @Test
    void createRacingCarGame_자동차최소2대미만시_예외처리(){
        // given
        final int loop = 3;

        final Car car1 = Car.createNamedCar("kim");
        final List<Car> oneCar = List.of(car1);

        // expect
        assertThatThrownBy(()->RacingCarGame.createLoopedRacingCarGame(loop,oneCar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 최소 2대부터 게임 가능합니다.");
    }

    @Test
    void createRacingCarGame_게임횟수1번미만시_예외처리(){
        // given
        final int lessThanOne = 0;
        final Car car1 = Car.createNamedCar("kim");
        final Car car2 = Car.createNamedCar("park");
        final List<Car> cars = List.of(car1,car2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(lessThanOne,cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임횟수 최소 1번부터 게임 가능합니다");
    }

    @Test
    void createRacingCarGame_게임횟수100번초과시_예외처리(){
        // given
        final int overThan100 = 101;
        final Car car1 = Car.createNamedCar("kim");
        final Car car2 = Car.createNamedCar("park");
        final List<Car> cars = List.of(car1,car2);

        // expect
        assertThatThrownBy(()-> RacingCarGame.createLoopedRacingCarGame(overThan100,cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임횟수 최대 100번까지 게임 가능합니다");
    }



}
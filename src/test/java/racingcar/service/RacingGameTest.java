package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {


    @Test
    void 우승자_반환_테스트(){

        //given
        List<Car> testCarList = new ArrayList<>();
        Car testCar1 = new Car("rang");
        Car testCar2 = new Car("joon");
        testCarList.add(testCar1);
        testCarList.add(testCar2);

        RacingGame racingGame = new RacingGame(testCarList);

        //when
        testCar1.moveCarForward();
        testCar1.moveCarForward();

        //then
        assertThat(racingGame.findWinner()).isEqualTo("rang");

    }
}

package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {


    List<Car> testCarList;
    @BeforeEach
    void setUp(){
        testCarList = Arrays.asList(new Car("joon"),new Car("rang"));
    }


    @Test
    void 우승자_반환_테스트(){

        //given
        RacingGame racingGame = new RacingGame(testCarList);

        //when
        testCarList.get(1).moveCarForward();
        testCarList.get(1).moveCarForward();

        //then
        assertThat(racingGame.findWinner()).isEqualTo("rang");

    }

    @Test
    void 전진_횟수_증가_테스트(){

        //given
        RacingGame racingGame = new RacingGame(testCarList);

        //when
        racingGame.moveForwardCar(testCarList.getFirst());

        //then
        assertThat(testCarList.getFirst().getMoveCount()).isEqualTo(1);


    }


}

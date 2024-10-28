package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class RacingGameTest {

    RacingGame racingGame;
    int Rounds = 3;
    @BeforeEach
    public void initGame() {
        racingGame = new RacingGame(List.of("car1", "car2"), new RandomMoveCondition(), Rounds);
    }

    @DisplayName("게임을 플레이하면 자동차들이 멈추거나 이동한다.")
    @Test
    void play() throws Exception{
        //given
        RacingCars racingCars = racingGame.playOneTime();
        //when
        List<Car> cars = racingCars.getCars();

        //then
        assertThat(cars).extracting(Car::getPosition)
                .allMatch(position -> position == 0 || position == 1);
     }

     @DisplayName("라운드 수만큼 플레이하면 더이상 플레이하지못한다.")
     @Test
     void oneGame() throws Exception{
         //given
         //when
         for (int i = 0; i < Rounds; i++) {
             racingGame.playOneTime();
         }
         //then
         assertThat(racingGame.isPlayable()).isFalse();
      }

}
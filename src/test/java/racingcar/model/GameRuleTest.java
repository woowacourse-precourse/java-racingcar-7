package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.GameRule;
import racingcar.modle.Movable;
import racingcar.modle.car.Car;
import racingcar.modle.car.CarFactory;

public class GameRuleTest {

    CarFactory carFactory;
    Movable car;
    GameRule gameRule;

    @BeforeEach
    public void setUp() {
        this.carFactory = new CarFactory();
        this.gameRule = new GameRule();
        this.car = carFactory.create("gamza");
    }

    @Test
    @DisplayName("4 이상일 경우 이동")
    public void goTest(){
        // given
        Movable movedCar = carFactory.create("newGamza");
        // when
        if(gameRule.isGo(4)){
            movedCar = car.move();
        }
        // then
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 이하일 경우 정지")
    public void stopTest(){
        // given
        Movable stoppedCar = carFactory.create("newGamza");
        // when
        if(gameRule.isGo(3)){
           stoppedCar =  car.move();
        }
        // then
        assertThat(stoppedCar.getPosition()).isEqualTo(0);
    }
}

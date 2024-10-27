package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.movableStrategy.BasicMoveStrategy;
import racingcar.modle.rule.GameRule;
import racingcar.modle.vehicle.Movable;
import racingcar.modle.vehicle.car.CarFactory;

public class GameRuleTest {

    private CarFactory carFactory;
    Movable car;  // 이거 접근제어자 추후 수정해야함
    GameRule gameRule; // 이거 접근제어자 추후 수정해야함

    @BeforeEach
    public void setUp() {
        this.carFactory = new CarFactory(new BasicMoveStrategy());
        this.gameRule = new GameRule();
        this.car = carFactory.create("gamza");
    }

    @Test
    @DisplayName("4 이상일 경우 이동")
    public void goTest(){
        // given
        Movable movedCar = carFactory.create("newGamza");
        // when
        if(gameRule.isMove(4)){
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
        if(gameRule.isMove(3)){
           stoppedCar =  car.move();
        }
        // then
        assertThat(stoppedCar.getPosition()).isEqualTo(0);
    }
}

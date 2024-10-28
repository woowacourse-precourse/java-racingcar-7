package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import racingcar.movableStrategy.BasicMoveStrategy;
import racingcar.movableStrategy.MoveStrategy;
import racingcar.modle.vehicle.car.Car;

public class CarTest {

    private Car car;
    private MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp() {
        car = new Car("gamza");
        moveStrategy = new BasicMoveStrategy();
    }

    @DisplayName("자동차 이동 기능 테스트")
    @RepeatedTest(value = 7, name = "자동차 이동 : {currentRepetition}/{totalRepetitions}")
    public void moveTest(RepetitionInfo repetitionInfo) {
        // when
        for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
            car = car.move(moveStrategy);
        }
        // then
        assertThat(car.getPosition()).isEqualTo(repetitionInfo.getCurrentRepetition());
    }

    @Test
    @DisplayName("자동차 이름 반환 테스트")
    public void carNameTst(){
        //given
        String exceptedName = "gamza";
        //when
        String actualName = car.getName();
        //then
        assertThat(actualName).isEqualTo(exceptedName);
    }
}

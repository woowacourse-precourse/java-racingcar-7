package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import racingcar.modle.movableStrategy.BasicMoveStrategy;
import racingcar.modle.vehicle.car.Car;
import racingcar.modle.vehicle.car.CarFactory;

public class CarTest {

    CarFactory carFactory = new CarFactory(new BasicMoveStrategy());
    private Car car = carFactory.create("gamza");

    @BeforeEach
    public void setUp() {
        car = carFactory.create("gamza");
    }

    @DisplayName("자동차 이동 기능 테스트")
    @RepeatedTest(value = 7, name = "자동차 이동 : {currentRepetition}/{totalRepetitions}")
    public void moveTest(RepetitionInfo repetitionInfo){
        // when
        for(int i = 0 ; i < repetitionInfo.getCurrentRepetition(); i++){
            car = car.move();
        }
        // then
        assertThat(car.getPosition()).isEqualTo(repetitionInfo.getCurrentRepetition());
    }
}

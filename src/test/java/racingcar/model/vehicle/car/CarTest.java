package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.modle.vehicle.car.Car;
import racingcar.modle.vehicle.car.CarFactory;

public class CarTest {

    CarFactory carFactory = new CarFactory();
    private Car car;

    @BeforeEach
    public void setUp() {
        car = carFactory.create("gamza");
    }

    @Test
    @DisplayName("자동차 이동 기능 테스트")
    public void moveTest(){
        // given
        int movedCount = 3;
        // when
        for(int i = 0; i < movedCount; i++){
            car = car.move(); // 이거 쫌 걸리는데... 흐음... 고민해보자
        }
        // then
        assertThat(car.getPosition()).isEqualTo(movedCount);
    }
}

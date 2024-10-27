package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;

class JudgmentTest {
    @Test
    void 가장_멀리_이동한_자동차_계산() {
        //given
        String car1Name = "test1";
        String car2Name = "test2";
        Cars cars = new Cars();
        Car car1 = new Car(car1Name);
        Car car2 = new Car(car2Name);
        car2.move();
        cars.addCar(car1);
        cars.addCar(car2);
        Judgment judgment = new Judgment();
        //when
        //then
        Assertions.assertThat(judgment.makeWinnerNameList(cars).getFirst()).isEqualTo(car2Name);
    }
}